package furama_resort.model.service;

import furama_resort.model.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
