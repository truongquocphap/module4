package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;
}
