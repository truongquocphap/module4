package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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

}
