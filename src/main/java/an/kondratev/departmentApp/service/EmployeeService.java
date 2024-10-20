package an.kondratev.departmentApp.service;

import an.kondratev.departmentApp.dto.EmployeeDTO;
import an.kondratev.departmentApp.mapper.DepartmentMapper;
import an.kondratev.departmentApp.mapper.EmployeeMapper;
import an.kondratev.departmentApp.model.Department;
import an.kondratev.departmentApp.model.Employee;
import an.kondratev.departmentApp.projections.DepartmentEmployees;
import an.kondratev.departmentApp.repository.DepartmentRepository;
import an.kondratev.departmentApp.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceInterface {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Department department;

        if (employeeDTO.getDepartmentId() != null) {
            department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElse(null);

        } else {
            department = DepartmentMapper.toEntity(employeeDTO.getDepartmentDTO());
            department = departmentRepository.save(department);
        }

        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(EmployeeMapper.toEntity(employeeDTO));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<DepartmentEmployees> findAllEmployeeProjectionByDepartmentId(Long id) {
        return employeeRepository.findAllEmployeeProjectionByDepartmentId(id);
    }
}
