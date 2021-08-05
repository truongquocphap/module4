package furama_resort.model.service;

import furama_resort.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service> serviceList(String name, Pageable pageable);
    Service findById(Integer id);
    void save(Service service);
    void deleteById(Integer id);
}
