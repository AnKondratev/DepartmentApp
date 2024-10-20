package an.kondratev.departmentApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private List<Long> employeeIds;
}