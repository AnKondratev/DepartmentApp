package an.kondratev.departmentApp.service;


import an.kondratev.departmentApp.dto.DepartmentDTO;
import an.kondratev.departmentApp.mapper.DepartmentMapper;
import an.kondratev.departmentApp.model.Department;
import an.kondratev.departmentApp.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService implements DepartmentServiceInterface {
    private DepartmentRepository departmentRepository;

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(DepartmentDTO departmentDTO) {
        return departmentRepository.save(DepartmentMapper.toEntity(departmentDTO));
    }

    @Override
    public Department updateDepartment(DepartmentDTO departmentDTO) {

        return departmentRepository.save(DepartmentMapper.toEntity(departmentDTO));
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
