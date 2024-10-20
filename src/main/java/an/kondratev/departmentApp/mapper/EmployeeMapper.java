package an.kondratev.departmentApp.mapper;

import an.kondratev.departmentApp.dto.EmployeeDTO;
import an.kondratev.departmentApp.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        return Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .position(employeeDTO.getPosition())
                .salary(employeeDTO.getSalary())
                .build();
    }

}

