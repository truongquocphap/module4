package furama_resort.model.dto;

import furama_resort.model.entity.ContractDetail;
import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Employee;
import furama_resort.model.entity.Service;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
    private Service service;
    private Customer customer;
    private Employee employee;

    public ContractDto() {
    }


    public ContractDto(LocalDate contractStartDate, String contractEndDate, double contractDeposit,
                       double contractTotalMoney, Service service, Customer customer, Employee employee) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.service = service;
        this.customer = customer;
        this.employee = employee;
    }

    public ContractDto(LocalDate contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney,
                       List<ContractDetail> contractDetailList, Service service, Customer customer, Employee employee) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.contractDetailList = contractDetailList;
        this.service = service;
        this.customer = customer;
        this.employee = employee;
    }
}
