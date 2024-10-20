package an.kondratev.departmentApp.controller;

import an.kondratev.departmentApp.dto.DepartmentDTO;
import an.kondratev.departmentApp.model.Department;
import an.kondratev.departmentApp.service.DepartmentServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class DepartmentController {
    private DepartmentServiceInterface departmentService;

    @PostMapping("new_department")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.addDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("find_department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Optional<Department> department = Optional.ofNullable(departmentService.getDepartment(id));
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("all_departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }

    @PutMapping("upt_department")
    public ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("del_department/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}
