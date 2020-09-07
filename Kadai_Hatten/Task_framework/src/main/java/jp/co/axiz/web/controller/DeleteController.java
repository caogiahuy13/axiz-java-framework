package jp.co.axiz.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.axiz.web.controller.form.DeleteConfirmForm;
import jp.co.axiz.web.controller.form.DeleteForm;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;

@Controller
public class DeleteController {
	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession httpSession;

	@GetMapping("delete")
	public String getDelete(@ModelAttribute DeleteForm deleteForm) {
		return "delete";
	}

	@PostMapping("deleteConfirm")
	public String postDeleteConfirm(@Validated @ModelAttribute DeleteForm deleteForm, BindingResult bindingResult,
			@ModelAttribute DeleteConfirmForm deleteConfirmForm,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "delete";
		}

		User user = userService.findByLoginId(deleteForm.getLoginId());

		if (user == null) {
			model.addAttribute("msg", messageSource.getMessage("loginId.isNotExisted", null, Locale.getDefault()));
			return "delete";
		}

		User currentUser = (User) httpSession.getAttribute("currentUser");

		if (currentUser.getLoginId().equals(user.getLoginId())) {
			model.addAttribute("msg", messageSource.getMessage("delete.fail.loginUser", null, Locale.getDefault()));
			return "delete";
		}

		model.addAttribute("deleteUser", user);
		deleteConfirmForm.setUserId(user.getUserId());
		return "deleteConfirm";
	}

	@PostMapping(value = "delete", params = "delete")
	public String postDelete(@ModelAttribute DeleteConfirmForm deleteConfirmForm) {
		if (userService.deleteById(deleteConfirmForm.getUserId()) <= 0) {
			return "deleteConfirm";
		}

		return "deleteResult";
	}

	@PostMapping(value = "delete", params = "return")
	public String postDelete(@ModelAttribute DeleteForm deleteForm) {
		return "delete";
	}
}
