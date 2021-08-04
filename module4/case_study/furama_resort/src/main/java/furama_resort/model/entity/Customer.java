package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "customer_name")
    private String customerName;
    private String birthday;
    private int gender;
    private String idCart;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id")
    private CustomerType customerType;
}
