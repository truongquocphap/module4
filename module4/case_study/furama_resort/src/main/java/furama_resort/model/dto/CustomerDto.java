package furama_resort.model.dto;

import furama_resort.model.entity.CustomerType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class CustomerDto {
    private Integer customerId;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "chỉ cho nhập ký tự chữ")
    private String customerName;
    private String birthday;
    @Pattern(regexp = "^KH-[0-9]{4}$",message="Nhập đúng định dạng KH-XXXX")
    private String customerCode;
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

    public CustomerDto() {
    }

    public CustomerDto(String customerName, String birthday, String customerCode, int gender, String idCart, String phone, String email, String address, CustomerType customerType, List<ContractDto> contractList) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.customerCode = customerCode;
        this.gender = gender;
        this.idCart = idCart;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractList = contractList;
    }
}
