package an.kondratev.departmentApp.service;


import an.kondratev.departmentApp.dto.EmployeeDTO;
import an.kondratev.departmentApp.model.Employee;
import an.kondratev.departmentApp.projections.DepartmentEmployees;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee saveEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);

    List<DepartmentEmployees> findAllEmployeeProjectionByDepartmentId(Long id);
}
