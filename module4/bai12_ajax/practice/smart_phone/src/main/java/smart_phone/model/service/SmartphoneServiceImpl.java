package smart_phone.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart_phone.model.entity.Smartphone;
import smart_phone.model.repository.ISmartphoneRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SmartphoneServiceImpl implements ISmartPhoneService{
    @Autowired
    ISmartphoneRepository smartphoneRepository;
    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
