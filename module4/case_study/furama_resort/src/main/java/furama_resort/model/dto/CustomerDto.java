package furama_resort.model.dto;

import furama_resort.model.entity.CustomerType;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class CustomerDto {
    private Integer customerId;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String customerName;
    private String birthday;
    @Pattern(regexp = "^KH-[0-9]{4}$")
    private String customerCode;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private int gender;
    @Pattern(regexp = "^[0-9]{10}$",message = "Id Cart phải được 10 chữ số")
    private String idCart;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email(message = "Email phải đúng định dạng abc@gmail.com")
    @NotBlank(message="Trường không được để trống")
    private String email;
    @NotBlank(message="Trường không được để trống")
    private String address;
    private CustomerType customerType;
    private List<ContractDto> contractList;
}
