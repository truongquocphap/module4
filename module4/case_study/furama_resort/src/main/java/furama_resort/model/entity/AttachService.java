package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;
    @Column(name = "attach_service_name")
    private String attachServiceName;
    @Column(name = "attach_service_cost")
    private double attachServiceCost;
    @Column(name = "attach_service_unit")
    private int attachServiceUnit;
    @Column(name = "attach_service_status")
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;
}
