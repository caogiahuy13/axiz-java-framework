package jp.co.axiz.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.controller.form.InsertConfirmForm;
import jp.co.axiz.web.controller.form.InsertForm;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;

@Controller
public class InsertController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/insert")
	public String getInsert(@ModelAttribute("insertForm") InsertForm insertForm) {
		insertForm.setRoleId(2);
		return "insert";
	}

	@RequestMapping(value = "/insert", params = "insert", method = RequestMethod.POST)
	public String postInsert(@ModelAttribute("insertConfirmForm") InsertConfirmForm insertConfirmForm, Model model) {
		if (!insertConfirmForm.getPass().equals(insertConfirmForm.getRePass())) {
			model.addAttribute("msg", messageSource.getMessage("rePass.isNotMatched", null, Locale.getDefault()));
			return "insertConfirm";
		}

		User user = User.builder()
				.loginId(insertConfirmForm.getLoginId())
				.userName(insertConfirmForm.getUserName())
				.telephone(insertConfirmForm.getTel())
				.password(insertConfirmForm.getPass())
				.roleId(insertConfirmForm.getRoleId())
				.build();

		if (userService.insert(user) <= 0) {
			return "insert";
		}

		return "insertResult";
	}

	@RequestMapping(value = "/insert", params = "return", method = RequestMethod.POST)
	public String postInsertReturn(@ModelAttribute("insertForm") InsertConfirmForm insertConfirmForm, Model model) {
		return "insert";
	}

	@PostMapping("/insertConfirm")
	public String postInsertConfirm(@Validated @ModelAttribute("insertForm") InsertForm insertForm,
			BindingResult bindingResult,
			@ModelAttribute("insertConfirmForm") InsertConfirmForm insertConfirmForm,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "insert";
		}

		if (userService.findByLoginId(insertForm.getLoginId()) != null) {
			model.addAttribute("msg", messageSource.getMessage("insert.id.isExisted", null, Locale.getDefault()));
			return "insert";
		}

		Role role = roleService.findById(insertForm.getRoleId());

		insertConfirmForm.setLoginId(insertForm.getLoginId());
		insertConfirmForm.setUserName(insertForm.getUserName());
		insertConfirmForm.setTel(insertForm.getTel());
		insertConfirmForm.setPass(insertForm.getPass());
		insertConfirmForm.setRoleId(insertForm.getRoleId());
		insertConfirmForm.setRoleName(role.getRoleName());

		return "insertConfirm";
	}

}
