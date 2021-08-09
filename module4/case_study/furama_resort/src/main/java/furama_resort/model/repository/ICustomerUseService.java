package furama_resort.model.repository;

import furama_resort.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerUseService extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract join customer on customer.customer_id=contract.customer_id" +
            " join contract_detail on contract.contract_id=contract_detail.contract_detail_id" +
            " join attach_service on contract_detail.attach_service_id=attach_service.attach_service_id",nativeQuery =true)
    Page<Contract> customerUseServiceList(Pageable pageable);
}
