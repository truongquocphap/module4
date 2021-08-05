package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
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
}
