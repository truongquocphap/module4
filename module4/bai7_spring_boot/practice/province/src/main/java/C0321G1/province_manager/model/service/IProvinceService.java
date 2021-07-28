package C0321G1.province_manager.model.service;

import C0321G1.province_manager.model.bean.Customer;
import C0321G1.province_manager.model.bean.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    List<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
