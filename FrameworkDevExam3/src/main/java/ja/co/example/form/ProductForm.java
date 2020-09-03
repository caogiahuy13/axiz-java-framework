package ja.co.example.form;

public class ProductForm {
	private String productName;
	private Integer price;

	public ProductForm() {

	}

	public ProductForm(String productName, Integer price) {
		super();
		this.productName = productName;
		this.price = price;
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
