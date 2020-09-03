package ja.co.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ja.co.example.controller.form.DeleteForm;
import ja.co.example.service.ProductService;

@Controller
public class DeleteController {
	@Autowired
	private ProductService productService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "delete")
	public String getDelete(@ModelAttribute("deleteForm") DeleteForm deleteForm) {
		return "delete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String postDelete(@Validated @ModelAttribute("deleteForm") DeleteForm deleteForm,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "delete";
		}

		if (productService.delete(deleteForm.getProductId()) <= 0) {
			String msg = messageSource.getMessage("search.result.isEmpty", null, Locale.getDefault());
			model.addAttribute("msg", msg);
			return "delete";
		}

		return "deleteResult";
	}
}
