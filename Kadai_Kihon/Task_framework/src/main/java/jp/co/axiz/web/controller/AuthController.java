package jp.co.axiz.web.controller;

import java.util.List;
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

import jp.co.axiz.web.controller.form.LoginForm;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;

@Controller
public class AuthController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession httpSession;

	@GetMapping("/login")
	public String getLogin(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "login";
	}

	@PostMapping("/login")
	public String postLogin(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "login";
		}

		User user = userService.authenticate(loginForm.getId(), loginForm.getPass());

		if (user == null) {
			model.addAttribute("msg", messageSource.getMessage("login.fail", null, Locale.getDefault()));
			return "login";
		}

		List<Role> roles = roleService.findAll();

		httpSession.setAttribute("roles", roles);
		httpSession.setAttribute("currentUser", user);

		return "redirect:/menu";
	}

	@PostMapping("/logout")
	public String postLogout() {
		httpSession.removeAttribute("currentUser");
		httpSession.removeAttribute("roles");
		return "logout";
	}
}
