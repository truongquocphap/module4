package furama_resort.model.dto;

import furama_resort.model.entity.ContractDetail;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class ContractDto {
    private Integer contractId;
    private LocalDate contractStartDate = LocalDate.now();
    private String contractEndDate;
    @NotNull(message = "Không được để trống")
    @Min(value = 1,message = "Area Phải lớn hơn 0")
    private double contractDeposit;
    @NotNull(message = "Không được để trống")
    @Min(value = 1,message = "Area Phải lớn hơn 0")
    private double contractTotalMoney;
    private List<ContractDetail> contractDetailList;
    private ServiceDto service;
    private CustomerDto customer;

    private EmployeeDto employee;
}
