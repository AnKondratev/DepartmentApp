package an.kondratev.departmentApp.projections;

import org.springframework.stereotype.Component;

@Component
public interface DepartmentEmployees {
    String getFullName();

    String getPosition();

    String getDepartmentName();
}