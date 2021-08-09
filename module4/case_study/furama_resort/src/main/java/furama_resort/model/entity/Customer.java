package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    private int deleteFlag;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Customer() {
    }

    public Customer(String customerName, String birthday, String customerCode, int gender, String idCart,
                    String phone, String email, String address, int deleteFlag, CustomerType customerType, List<Contract> contractList) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.customerCode = customerCode;
        this.gender = gender;
        this.idCart = idCart;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.deleteFlag = deleteFlag;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Customer(String customerName, String birthday, String customerCode, int gender,
                    String idCart, String phone, String email, String address, int deleteFlag, CustomerType customerType) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.customerCode = customerCode;
        this.gender = gender;
        this.idCart = idCart;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.deleteFlag = deleteFlag;
        this.customerType = customerType;
    }
}
