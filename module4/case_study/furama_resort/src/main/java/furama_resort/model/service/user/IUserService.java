package furama_resort.model.service.user;


import furama_resort.model.entity.user.User;

public interface IUserService {
    User findByUsername(String username);
}
