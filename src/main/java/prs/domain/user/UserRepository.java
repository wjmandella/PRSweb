//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//More specifically...
//https://spring.io/guides/gs/accessing-data-mysql/

package prs.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserNameAndPassword(String username, String password);
}
