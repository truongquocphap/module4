package furama_resort.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;
    @Column(name = "contract_quantity")
    private int quantity;
    private int deleteFlag;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attach_service_id")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int quantity, int deleteFlag, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.deleteFlag = deleteFlag;
        this.attachService = attachService;
        this.contract = contract;
    }
}
