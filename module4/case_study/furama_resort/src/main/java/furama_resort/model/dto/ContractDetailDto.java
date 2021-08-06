package furama_resort.model.dto;

import furama_resort.model.entity.AttachService;
import furama_resort.model.entity.Contract;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContractDetailDto {
    private Integer contractDetailId;
    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Area Phải lớn hơn 0")
    private int quantity;
    private AttachService attachService;
    private Contract contract;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }
}
