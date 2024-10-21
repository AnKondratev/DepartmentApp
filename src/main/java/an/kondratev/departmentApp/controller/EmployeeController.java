package an.kondratev.departmentApp.controller;

import an.kondratev.departmentApp.dto.EmployeeDTO;
import an.kondratev.departmentApp.model.Employee;
import an.kondratev.departmentApp.projections.DepartmentEmployees;
import an.kondratev.departmentApp.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class EmployeeController {
    private EmployeeServiceInterface employeeService;

    @GetMapping("open/department employees/{id}")
    public ResponseEntity<List<DepartmentEmployees>> getEmployeeProjections(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findAllEmployeeProjectionByDepartmentId(id), HttpStatus.OK);
    }

    @PostMapping("secure/new_employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("open/find_employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.getEmployeeById(id));
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("open/all_employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PutMapping("secure/upt_employee")
    public ResponseEntity<Employee> updateDepartment(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("secure/del_employees/{id}")
    public ResponseEntity<Void> deleteEmployees(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
