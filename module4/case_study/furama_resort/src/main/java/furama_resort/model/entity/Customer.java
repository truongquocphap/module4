package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "customer_name")
    private String customerName;
    private String birthday;
    @Column(name = "customer_code")
    private String customerCode;
    private int gender;
    private String idCart;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contractList;
}
