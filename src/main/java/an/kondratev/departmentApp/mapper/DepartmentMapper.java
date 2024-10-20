package an.kondratev.departmentApp.mapper;

import an.kondratev.departmentApp.dto.DepartmentDTO;
import an.kondratev.departmentApp.model.Department;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DepartmentMapper {

    public static Department toEntity(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .build();
    }
}
