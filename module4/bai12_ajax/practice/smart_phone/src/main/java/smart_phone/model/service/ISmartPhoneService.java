package smart_phone.model.service;

import smart_phone.model.entity.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    List<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
