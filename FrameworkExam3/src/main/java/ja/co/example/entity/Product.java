package ja.co.example.entity;

public class Product {
	private Integer productId;
	private String productName;
	private Integer price;

	public Product() {
	}

	public Product(Integer productId, String productName, Integer price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public Product(String productName, Integer price) {
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

	@Override
	public String toString() {
		return String.format("product_id:%d, product_name:%s, price:%d", productId, productName, price);
	}
}
