//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//https://spring.io/guides/gs/accessing-data-mysql/

package prs.domain.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
		List<Product> findAllByVendorID(int id);
		List<Product> findAllByVendorIDNot(int id);
}
