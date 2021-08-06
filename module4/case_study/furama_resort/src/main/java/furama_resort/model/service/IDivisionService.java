package furama_resort.model.service;

import furama_resort.model.entity.DivisionEmployee;

import java.util.List;

public interface IDivisionService {
    List<DivisionEmployee> findAll();
}
