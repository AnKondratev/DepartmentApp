package an.kondratev.departmentApp.repository;


import an.kondratev.departmentApp.model.Employee;
import an.kondratev.departmentApp.projections.DepartmentEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) AS fullName, e.position AS position, d.name AS departmentName FROM Employee e JOIN e.department d")
    List<DepartmentEmployees> findAllEmployeeProjectionByDepartmentId(Long id);
}
