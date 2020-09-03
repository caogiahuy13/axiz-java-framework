package ja.co.example.controller;

import java.util.List;
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

import ja.co.example.entity.Product;
import ja.co.example.form.ProductForm;
import ja.co.example.service.ProductService;
import ja.co.example.util.ParamUtil;

@Controller
public class TestController {

	@Autowired
	private ProductService productService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping("/top")
	public String getTop(@ModelAttribute("product") ProductForm productform) {
		return "top";
	}

	@RequestMapping(value = "/top", params = "search", method = RequestMethod.POST)
	public String postTopSearch(@ModelAttribute("product") ProductForm productForm, Model model) {
		String name = ParamUtil.isNullOrEmpty(productForm.getProductName()) ? null : productForm.getProductName();
		Integer price = productForm.getPrice() == null ? null : productForm.getPrice();

		List<Product> products = productService.find(name, price);

		if (products.isEmpty()) {
			String msg = messageSource.getMessage("search.result.isEmpty", null, Locale.getDefault());
			model.addAttribute("msg", msg);
			return "top";
		}

		model.addAttribute("products", products);

		return "searchResult";
	}

	@RequestMapping(value = "/top", params = "register", method = RequestMethod.POST)
	public String postTopRegister(@Validated @ModelAttribute("product") ProductForm productForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "top";
		}

		Product product = new Product(productForm.getProductName(), productForm.getPrice());

		if (productService.insert(product) > 0) {
			return "insertResult";
		}

		return "top";
	}
}
