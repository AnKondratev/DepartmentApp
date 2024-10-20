package an.kondratev.departmentApp.service;

import an.kondratev.departmentApp.dto.DepartmentDTO;
import an.kondratev.departmentApp.model.Department;
import an.kondratev.departmentApp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    private Department department;
    private DepartmentDTO departmentDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        department = Department.builder().id(1L).name("HR").build();
        departmentDTO = new DepartmentDTO(1L, "HR", null);
    }

    @Test
    public void testGetDepartment() {
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        Department result = departmentService.getDepartment(1L);

        assertNotNull(result);
        assertEquals("HR", result.getName());
        verify(departmentRepository).findById(1L);
    }

    @Test
    public void testGetAllDepartments() {
        when(departmentRepository.findAll()).thenReturn(Collections.singletonList(department));

        List<Department> result = departmentService.getAllDepartments();

        assertEquals(1, result.size());
        assertEquals("HR", result.get(0).getName());
        verify(departmentRepository).findAll();
    }

    @Test
    public void testAddDepartment() {
        Department newDepartment = new Department();
        newDepartment.setId(departmentDTO.getId());
        newDepartment.setName(departmentDTO.getName());

        when(departmentRepository.save(any(Department.class))).thenReturn(newDepartment);

        Department result = departmentService.addDepartment(departmentDTO);

        assertNotNull(result);
        assertEquals("HR", result.getName());
        verify(departmentRepository).save(newDepartment);
    }

    @Test
    public void testUpdateDepartment() {
        Department updatedDepartment = new Department();
        updatedDepartment.setId(departmentDTO.getId());
        updatedDepartment.setName(departmentDTO.getName());

        when(departmentRepository.save(any(Department.class))).thenReturn(updatedDepartment);

        Department result = departmentService.updateDepartment(departmentDTO);

        assertNotNull(result);
        assertEquals("HR", result.getName());
        verify(departmentRepository).save(updatedDepartment);
    }

    @Test
    public void testDeleteDepartment() {
        doNothing().when(departmentRepository).deleteById(1L);

        departmentService.deleteDepartment(1L);

        verify(departmentRepository).deleteById(1L);
    }
}

