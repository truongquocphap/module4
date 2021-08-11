package furama_resort.model.service.impl.user;

import furama_resort.model.entity.user.User;
import furama_resort.model.repository.user.IUserRepository;
import furama_resort.model.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
