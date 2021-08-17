package C0321G1.province_manager.model.service;

import C0321G1.province_manager.model.bean.Customer;
import C0321G1.province_manager.model.bean.Province;
import C0321G1.province_manager.model.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return (List<Province>) iProvinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
