package validate_form.model.service;

import org.springframework.stereotype.Service;
import validate_form.model.entity.User;


public interface IUserService {
    void save(User user);
}
