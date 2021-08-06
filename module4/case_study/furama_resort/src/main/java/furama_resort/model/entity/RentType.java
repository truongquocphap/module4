package furama_resort.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
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

    public RentType() {
    }

    public RentType(String rentTypeName, double rentTypeCost, List<Service> serviceList) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceList = serviceList;
    }
}
