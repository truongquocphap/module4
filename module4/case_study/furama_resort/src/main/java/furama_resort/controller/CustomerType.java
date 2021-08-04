package furama_resort.controller;

import furama_resort.model.entity.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer customerTypeId;
    @Column(name = "customer_type_name")
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> customerList;
}
