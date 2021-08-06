package furama_resort.model.repository;

import furama_resort.model.entity.Contract;
import furama_resort.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where concat(contract_start_date,contract_end_date) like %?1% ",nativeQuery = true)
    Page<Contract> contractList(String name, Pageable pageable);
}
