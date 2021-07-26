package validate_form.model.repository;

import org.springframework.data.repository.CrudRepository;
import validate_form.model.entity.User;

public interface IUserRepository extends CrudRepository<User,Integer> {
}
