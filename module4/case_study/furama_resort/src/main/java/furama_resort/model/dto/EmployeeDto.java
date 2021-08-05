package furama_resort.model.dto;

import furama_resort.model.entity.DivisionEmployee;
import furama_resort.model.entity.EducationEmployee;
import furama_resort.model.entity.Position;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.*;
import javax.xml.ws.soap.Addressing;
import java.util.List;

@Data
public class EmployeeDto {
    private Integer employeeId;
    @NotBlank(message = "Trường không được để trống")
    private String employeeName;
    private String birthday;
    @Pattern(regexp = "^//d{10}$")
    @NotNull
    private String employeeIdCart;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private Double employeeSalary;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String employeePhone;
    @Email(message = "Email phải đúng định dạng abc@gmail.com")
    @NotBlank(message="Trường không được để trống")
    private String employeeEmail;
    @NotBlank(message="Trường không được để trống")
    private String employeeAddress;
    @NotBlank(message="Trường không được để trống")
    private Position position;
    private EducationEmployee educationEmployee;
    private DivisionEmployee divisionEmployee;
    private List<ContractDto> contractList;
}
