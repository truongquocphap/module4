package furama_resort.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "date")
    private String birthday;
    @Column(name = "employee_id_cart")
    private String employeeIdCart;
    @Column(name = "employee_salary")
    private Double employeeSalary;
    @Column(name = "employee_phone")
    private String employeePhone;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_address")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_id",referencedColumnName = "education_id")
    private EducationEmployee educationEmployee;
    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "division_id")
    private DivisionEmployee divisionEmployee;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Employee() {
    }

    public Employee(String employeeName, String birthday, String employeeIdCart, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position,
                    EducationEmployee educationEmployee, DivisionEmployee divisionEmployee, List<Contract> contractList) {
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.employeeIdCart = employeeIdCart;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationEmployee = educationEmployee;
        this.divisionEmployee = divisionEmployee;
        this.contractList = contractList;
    }
}
