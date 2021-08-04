package furama_resort.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;
    @Column(name = "position_name")
    private String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private List<Employee> employeeList;
}
