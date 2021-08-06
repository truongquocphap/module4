package furama_resort.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class EducationEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "education_id")
    private Integer educationId;
    @Column(name = "education_name")
    private String educationName;
    @OneToMany(mappedBy = "educationEmployee",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public EducationEmployee() {
    }

    public EducationEmployee(String educationName, List<Employee> employeeList) {
        this.educationName = educationName;
        this.employeeList = employeeList;
    }
}
