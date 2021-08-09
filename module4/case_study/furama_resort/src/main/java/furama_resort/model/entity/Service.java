package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_area")
    private int serviceArea;
    @Column(name = "service_cost")
    private Double serviceCost;
    @Column(name = "max_people")
    private int maxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description")
    private String description;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_floors")
    private int numberFloors;
    @Column(name = "service_code")
    private String serviceCode;
    private int deleteFlag;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Service() {
    }

    public Service(String serviceName, int serviceArea, Double serviceCost, int maxPeople, String standardRoom, String description, Double poolArea, int numberFloors,
                   String serviceCode, int deleteFlag, ServiceType serviceType, RentType rentType, List<Contract> contractList) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.serviceCode = serviceCode;
        this.deleteFlag = deleteFlag;
        this.serviceType = serviceType;
        this.rentType = rentType;
        this.contractList = contractList;
    }

    public Service(String serviceName, int serviceArea, Double serviceCost, int maxPeople, String standardRoom, String description, Double poolArea,
                   int numberFloors, String serviceCode, int deleteFlag, ServiceType serviceType, RentType rentType) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.serviceCode = serviceCode;
        this.deleteFlag = deleteFlag;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }
}
