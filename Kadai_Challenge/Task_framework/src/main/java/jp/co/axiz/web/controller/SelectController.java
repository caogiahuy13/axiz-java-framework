package jp.co.axiz.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
import jp.co.axiz.web.controller.form.SelectResultForm;
import jp.co.axiz.web.controller.form.UpdateInputForm;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;

@Controller
public class SelectController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession session;

	@GetMapping("select")
	public String getSelect(@ModelAttribute SelectForm selectForm) {
		return "select";
	}

	@PostMapping("select")
	public String getSelect(@ModelAttribute SelectForm selectForm, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes, @ModelAttribute SelectResultForm selectResultForm) {
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

		session.setAttribute("resultUsers", users);
		return "selectResult";
	}

	@GetMapping("selectResult")
	public String getSelectResult(@ModelAttribute SelectResultForm selectResultForm) {
		return "selectResult";
	}

	@PostMapping(value = "selectResult", params = "delete")
	public String postSelectResultGetDelete(@ModelAttribute SelectResultForm selectResultForm, Model model) {
		if (selectResultForm.getUserIDs().length <= 0) {
			model.addAttribute("msg",
					messageSource.getMessage("page.selectResult.table.checkboxes.delete.isEmpty", null,
							Locale.getDefault()));
			return "selectResult";
		}

		User currentUser = (User) session.getAttribute("currentUser");
		for (int i = 0; i < selectResultForm.getUserIDs().length; i++) {
			if (currentUser.getUserId() == Integer.parseInt(selectResultForm.getUserIDs()[i])) {
				model.addAttribute("msg",
						messageSource.getMessage("delete.fail.loginUser", null,
								Locale.getDefault()));
				return "selectResult";
			}
		}

		List<User> users = new ArrayList<User>();
		for (int i = 0; i < selectResultForm.getUserIDs().length; i++) {
			User user = userService.findById(Integer.parseInt(selectResultForm.getUserIDs()[i]));
			users.add(user);
		}

		session.setAttribute("usersToDelete", users);
		return "selectResultDelete";
	}

	@PostMapping(value = "selectResult", params = "edit")
	public String postSelectResultEdit(@ModelAttribute SelectResultForm selectResultForm, Model model,
			@ModelAttribute UpdateInputForm updateInputForm) {
		if (selectResultForm.getUserIDs().length <= 0) {
			model.addAttribute("msg", messageSource.getMessage("page.selectResult.table.checkboxes.edit.isEmpty", null,
					Locale.getDefault()));
			return "selectResult";
		}

		if (selectResultForm.getUserIDs().length > 1) {
			model.addAttribute("msg",
					messageSource.getMessage("page.selectResult.table.checkboxes.edit.isBiggerThanOne", null,
							Locale.getDefault()));
			return "selectResult";
		}

		User user = userService.findById(Integer.parseInt(selectResultForm.getUserIDs()[0]));

		session.setAttribute("prevUser", user);

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

	@PostMapping(value = "selectResultDelete", params = "return")
	public String postSelectResultDeleteReturn(@ModelAttribute SelectResultForm selectResultForm) {
		return "selectResult";
	}

	@PostMapping(value = "selectResultDelete", params = "delete")
	public String postSelectResultDeleteDelete(@ModelAttribute SelectResultForm selectResultForm) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.getAttribute("usersToDelete");

		users.forEach(u -> userService.deleteById(u.getUserId()));

		return "deleteResult";
	}

}
