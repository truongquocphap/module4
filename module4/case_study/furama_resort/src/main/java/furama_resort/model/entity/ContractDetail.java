package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;
    @Column(name = "contract_quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attach_service_id")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(referencedColumnName = "contract_id")
    private Contract contract;
}
