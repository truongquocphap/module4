package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    @Column(name = "service_type_name")
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    private List<Service> serviceList;
}
