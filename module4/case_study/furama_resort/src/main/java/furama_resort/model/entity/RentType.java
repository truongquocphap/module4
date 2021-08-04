package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;
    @Column(name = "rent_type_name")
    private String rentTypeName;
    @Column(name = "rent_type_cost")
    private double rentTypeCost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<Service> serviceList;
}
