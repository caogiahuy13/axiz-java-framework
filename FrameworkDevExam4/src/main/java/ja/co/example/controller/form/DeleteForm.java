package ja.co.example.controller.form;

import javax.validation.constraints.NotNull;

public class DeleteForm {
	@NotNull
	private Integer productId;

	public DeleteForm() {

	}

	public DeleteForm(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
