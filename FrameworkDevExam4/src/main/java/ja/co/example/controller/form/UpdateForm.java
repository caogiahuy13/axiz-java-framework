package ja.co.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateForm {
	@NotNull
	private Integer productId;

	@NotBlank
	private String productName;

	@NotNull
	private Integer price;

	public UpdateForm() {

	}

	public UpdateForm(Integer productId, String productName, Integer price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
