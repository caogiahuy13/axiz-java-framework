package jp.co.axiz.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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

import jp.co.axiz.web.controller.form.UpdateConfirmForm;
import jp.co.axiz.web.controller.form.UpdateForm;
import jp.co.axiz.web.controller.form.UpdateInputForm;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;

@Controller
public class UpdateController {
	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	RoleService roleService;

	@Autowired
	HttpSession httpSession;

	@GetMapping("update")
	public String getUpdate(@ModelAttribute UpdateForm updateForm) {
		return "update";
	}

	@PostMapping("updateInput")
	public String postUpdateInput(@Validated @ModelAttribute UpdateForm updateForm, BindingResult bindingResult,
			Model model, @ModelAttribute UpdateInputForm updateInputForm) {
		if (bindingResult.hasErrors()) {
			return "update";
		}

		User user = userService.findByLoginId(updateForm.getLoginId());

		if (user == null) {
			model.addAttribute("msg", messageSource.getMessage("loginId.isNotExisted", null, Locale.getDefault()));
			return "update";
		}

		httpSession.setAttribute("prevUser", user);

		Role role = roleService.findById(user.getRoleId());

		updateInputForm.setUserId(user.getUserId());
		updateInputForm.setLoginId(user.getLoginId());
		updateInputForm.setUserName(user.getUserName());
		updateInputForm.setRoleId(user.getRoleId());
		updateInputForm.setRoleName(role.getRoleName());
		updateInputForm.setTel(user.getTelephone());
		updateInputForm.setPass(user.getPassword());

		return "updateInput";
	}

	@PostMapping(value = "updateConfirm", params = "return")
	public String postUpdateConfirmReturn(@ModelAttribute UpdateForm updateForm, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		String lastScreen = referer.substring(referer.lastIndexOf('/') + 1).trim();
		if (lastScreen.equals("updateInput")) {
			return "update";
		}

		return "redirect:" + referer;
	}

	@PostMapping(value = "updateConfirm", params = "confirm")
	public String postUpdateConfirm(@Validated @ModelAttribute UpdateInputForm updateInputForm,
			BindingResult bindingResult, Model model, @ModelAttribute UpdateConfirmForm updateConfirmForm) {
		if (bindingResult.hasErrors()) {
			return "updateInput";
		}

		User user = (User) httpSession.getAttribute("prevUser");

		if (user.getLoginId().equals(updateInputForm.getLoginId())
				&& user.getUserName().equals(updateInputForm.getUserName())
				&& user.getTelephone().equals(updateInputForm.getTel())
				&& user.getRoleId() == updateInputForm.getRoleId()
				&& user.getPassword().equals(updateInputForm.getPass())) {
			model.addAttribute("msg",
					messageSource.getMessage("update.noChange", null, Locale.getDefault()));
			return "updateInput";
		}

		if (!user.getLoginId().equals(updateInputForm.getLoginId())) {
			if (userService.findByLoginId(updateInputForm.getLoginId()) != null) {
				model.addAttribute("msg", messageSource.getMessage("loginId.isExisted", null, Locale.getDefault()));
				return "updateInput";
			}
		}

		Role role = roleService.findById(updateInputForm.getRoleId());

		updateConfirmForm.setUserId(updateInputForm.getUserId());
		updateConfirmForm.setLoginId(updateInputForm.getLoginId());
		updateConfirmForm.setUserName(updateInputForm.getUserName());
		updateConfirmForm.setRoleId(updateInputForm.getRoleId());
		updateConfirmForm.setTel(updateInputForm.getTel());
		updateConfirmForm.setPass(updateInputForm.getPass());
		updateConfirmForm.setRoleName(role.getRoleName());
		if (user.getPassword().equals(updateInputForm.getPass())) {
			updateConfirmForm.setRePass(updateInputForm.getPass());
		}

		return "updateConfirm";
	}

	@PostMapping(value = "update", params = "return")
	public String postUpdateReturn(@ModelAttribute UpdateInputForm updateInputForm,
			@ModelAttribute UpdateConfirmForm updateConfirmForm) {
		return "updateInput";
	}

	@PostMapping(value = "update", params = "update")
	public String postUpdate(@Validated @ModelAttribute UpdateConfirmForm updateConfirmForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "updateConfirm";
		}

		if (!updateConfirmForm.getPass().equals(updateConfirmForm.getRePass())) {
			model.addAttribute("msg", messageSource.getMessage("rePass.isNotMatched", null, Locale.getDefault()));
			return "updateConfirm";
		}

		User user = User.builder()
				.userId(updateConfirmForm.getUserId())
				.loginId(updateConfirmForm.getLoginId())
				.userName(updateConfirmForm.getUserName())
				.telephone(updateConfirmForm.getTel())
				.password(updateConfirmForm.getPass())
				.roleId(updateConfirmForm.getRoleId())
				.build();

		if (userService.update(user) <= 0) {
			return "updateConfirm";
		}

		return "updateResult";
	}

}
