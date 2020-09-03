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

import ja.co.example.controller.form.UpdateForm;
import ja.co.example.entity.Product;
import ja.co.example.service.ProductService;

@Controller
public class UpdateController {
	@Autowired
	private ProductService productService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "update")
	public String getUpdate(@ModelAttribute("updateForm") UpdateForm updateForm) {
		return "update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String postUpdate(@Validated @ModelAttribute("updateForm") UpdateForm updateForm,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "update";
		}

		Product product = productService.findById(updateForm.getProductId());

		if (product == null) {
			String msg = messageSource.getMessage("search.result.isEmpty", null, Locale.getDefault());
			model.addAttribute("msg", msg);
			return "update";
		}

		Product newProduct = new Product(updateForm.getProductId(), updateForm.getProductName(), updateForm.getPrice());

		if (productService.update(newProduct) <= 0) {
			String msg = messageSource.getMessage("search.result.isEmpty", null, Locale.getDefault());
			model.addAttribute("msg", msg);
			return "update";
		}

		model.addAttribute("oldProduct", product);
		model.addAttribute("newProduct", newProduct);
		return "updateResult";
	}

}
