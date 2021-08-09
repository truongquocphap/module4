package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    @Column(name = "contract_start_date")
    private LocalDate contractStartDate = LocalDate.now();
    @Column(name = "contract_end_date")
    private String contractEndDate;
    @Column(name = "contract_deposit")
    private double contractDeposit;
    @Column(name = "contract_total_money")
    private double contractTotalMoney;
    private int deleteFlag;
   @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;
   @ManyToOne
   @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private Service service;
   @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;
   @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    public Contract() {
    }

    public Contract(LocalDate contractStartDate, String contractEndDate, double contractDeposit,
                    double contractTotalMoney, int deleteFlag, List<ContractDetail> contractDetailList, Service service, Customer customer, Employee employee) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.deleteFlag = deleteFlag;
        this.contractDetailList = contractDetailList;
        this.service = service;
        this.customer = customer;
        this.employee = employee;
    }

    public Contract(LocalDate contractStartDate, String contractEndDate, double contractDeposit,
                    double contractTotalMoney, int deleteFlag, Service service, Customer customer, Employee employee) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.deleteFlag = deleteFlag;
        this.service = service;
        this.customer = customer;
        this.employee = employee;
    }
}
