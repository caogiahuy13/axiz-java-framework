package jp.co.axiz.web.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.axiz.web.controller.form.SelectForm;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;

@Controller
public class SelectController {
	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/select")
	public String getSelect(@ModelAttribute("selectForm") SelectForm selectForm) {
		return "select";
	}

	@PostMapping("/select")
	public String getSelect(@ModelAttribute("selectForm") SelectForm selectForm, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "select";
		}

		User user = User.builder()
				.userName(selectForm.getUserName())
				.telephone(selectForm.getTel())
				.build();

		List<User> users = userService.find(user);

		if (users.isEmpty()) {
			model.addAttribute("msg", messageSource.getMessage("select.isEmpty", null, Locale.getDefault()));
			return "select";
		}

		redirectAttributes.addFlashAttribute("users", users);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String getList() {
		return "selectResult";
	}
}
