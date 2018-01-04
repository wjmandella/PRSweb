//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//More specifically...
//https://spring.io/guides/gs/accessing-data-mysql/

package prs.domain.status;

import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {

	
}
