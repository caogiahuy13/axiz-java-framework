package ja.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ja.co.example.entity.Product;
import ja.co.example.form.ProductForm;
import ja.co.example.service.ProductService;

@Controller
public class TestController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/top")
	public String getTop(@ModelAttribute("product") ProductForm productform) {
		return "top";
	}

	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public String postTop(@ModelAttribute("product") ProductForm productForm, Model model) {
		Product product = productService.findById(productForm.getProductId());

		if (product == null) {
			model.addAttribute("msg", "対象のデータはありません");
			return "top";
		}

		model.addAttribute("product", product);
		return "searchResult";
	}
}
