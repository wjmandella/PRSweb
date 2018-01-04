//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//More specifically...
//https://spring.io/guides/gs/accessing-data-mysql/

package prs.domain.vendor;

import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

	
}
