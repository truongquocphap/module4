package furama_resort.model.service;

import furama_resort.model.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
