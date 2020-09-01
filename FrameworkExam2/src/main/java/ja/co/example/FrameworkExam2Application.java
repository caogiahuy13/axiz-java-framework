package ja.co.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ja.co.example.dao.ProductDao;

@SpringBootApplication
public class FrameworkExam2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FrameworkExam2Application.class, args);
		ProductDao productDao = context.getBean(ProductDao.class);

		Integer productId = 104;

		if (productDao.delete(productId) > 0) {
			System.out.println("削除しました");
		} else {
			System.out.println("対象のデータはありません");
		}
	}

}
