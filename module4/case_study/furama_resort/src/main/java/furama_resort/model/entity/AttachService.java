package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    public AttachService() {
    }

    public AttachService(String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetailList) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailList = contractDetailList;
    }
}
