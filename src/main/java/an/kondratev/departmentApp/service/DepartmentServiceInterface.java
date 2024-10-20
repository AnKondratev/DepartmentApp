package an.kondratev.departmentApp.service;


import an.kondratev.departmentApp.dto.DepartmentDTO;
import an.kondratev.departmentApp.model.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    Department getDepartment(Long id);
    List<Department> getAllDepartments();
    Department addDepartment(DepartmentDTO departmentDTO);
    Department updateDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(Long id);
}
