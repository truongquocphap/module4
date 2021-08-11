package furama_resort.model.dto;

import furama_resort.model.entity.DivisionEmployee;
import furama_resort.model.entity.EducationEmployee;
import furama_resort.model.entity.Position;
import furama_resort.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class EmployeeDto {
    private Integer employeeId;
    @NotBlank(message = "Trường không được để trống")
    private String employeeName;
    private String birthday;
    @Pattern(regexp = "^[0-9]{10}$",message = "Id Card Phải 10 số")
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
    private int deleteFlag;
    private Position position;
    private EducationEmployee educationEmployee;
    private DivisionEmployee divisionEmployee;
    private List<ContractDto> contractList;
    private User user;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeName, String birthday, String employeeIdCart, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int deleteFlag, Position position,
                       EducationEmployee educationEmployee, DivisionEmployee divisionEmployee, List<ContractDto> contractList) {
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.employeeIdCart = employeeIdCart;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.deleteFlag = deleteFlag;
        this.position = position;
        this.educationEmployee = educationEmployee;
        this.divisionEmployee = divisionEmployee;
        this.contractList = contractList;
    }

    public EmployeeDto(String employeeName, String birthday, String employeeIdCart, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int deleteFlag, Position position,
                       EducationEmployee educationEmployee, DivisionEmployee divisionEmployee, List<ContractDto> contractList, User user) {
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.employeeIdCart = employeeIdCart;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.deleteFlag = deleteFlag;
        this.position = position;
        this.educationEmployee = educationEmployee;
        this.divisionEmployee = divisionEmployee;
        this.contractList = contractList;
        this.user = user;
    }
}
