package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
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

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName, List<Service> serviceList) {
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }
}
