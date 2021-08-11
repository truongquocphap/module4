package furama_resort.model.repository;

import furama_resort.model.entity.ContractDetail;
import furama_resort.model.dto.ContractDetailOther;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select * from contract_detail join contract on contract_detail.contract_id=contract.contract_id" +
                   " where concat(contract.contract_start_date,contract.contract_end_date) like  %?1% and contract_detail.delete_flag = 1",nativeQuery = true)
    Page<ContractDetail> contractDetailList(String name, Pageable pageable);
    @Query(value = " select sum(contract_detail.contract_quantity) as quantity," +
            " contract_detail.attach_service_id as attachServiceId , contract_detail.contract_id as contractId," +
            " attach_service.attach_service_name as attachServiceName" +
            " from contract_detail " +
            " join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id" +
            " group by contract_detail.attach_service_id , contract_detail.contract_id",nativeQuery = true)
    List<ContractDetailOther> contractDetailOtherList();
    List<ContractDetail> findAllByContract_ContractId(Integer id);
}
