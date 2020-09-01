package ja.co.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ja.co.example.dao.ProductDao;
import ja.co.example.entity.Product;

@SpringBootApplication
public class FrameworkDevExam2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FrameworkDevExam2Application.class, args);
		ProductDao productDao = context.getBean(ProductDao.class);

		Product product = new Product(122, "コンパス", 150);

		if (productDao.update(product) <= 0) {
			productDao.insert(product);
		}

		productDao.findAll().forEach(p -> System.out.println(p));

	}
}
