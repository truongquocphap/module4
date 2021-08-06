package furama_resort.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class DivisionEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "division_name")
    private String divisionName;
    @OneToMany(mappedBy = "divisionEmployee",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public DivisionEmployee() {
    }

    public DivisionEmployee(String divisionName, List<Employee> employeeList) {
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }
}
