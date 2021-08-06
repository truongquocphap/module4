package furama_resort.model.repository;

import furama_resort.model.entity.Contract;
import furama_resort.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select * from contract_detail join contract on contract_detail.contract_id=contract.contract_id" +
                   " where concat(contract_start_date,contract_end_date) like  %?1% ",nativeQuery = true)
    Page<ContractDetail> contractDetailList(String name, Pageable pageable);
}
