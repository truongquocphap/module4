package furama_resort.model.repository;

import furama_resort.model.entity.Contract;
import furama_resort.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where concat(contract_start_date,contract_end_date) like %?1% and delete_flag = 1 ",nativeQuery = true)
    Page<Contract> contractList(String name, Pageable pageable);
    @Query(value = "select *from contract join customer on contract.customer_id=customer.customer_id " +
            " where (current_date() between contract.contract_start_date and contract.contract_end_date) and customer.customer_name like %?1% ",nativeQuery = true)
    Page<Contract> contractUseServiceList(Pageable pageable,String name);

}
