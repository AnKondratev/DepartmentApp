package an.kondratev.departmentApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private double salary;
    private Long departmentId;
    private DepartmentDTO departmentDTO;
}
