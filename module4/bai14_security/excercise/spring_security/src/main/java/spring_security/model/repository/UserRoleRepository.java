package spring_security.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_security.model.entity.AppUser;
import spring_security.model.entity.UserRole;

import java.util.List;
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
