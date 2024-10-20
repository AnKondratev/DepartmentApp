package an.kondratev.departmentApp.service;

import an.kondratev.departmentApp.dto.EmployeeDTO;
import an.kondratev.departmentApp.model.Department;
import an.kondratev.departmentApp.model.Employee;
import an.kondratev.departmentApp.projections.DepartmentEmployees;
import an.kondratev.departmentApp.repository.DepartmentRepository;
import an.kondratev.departmentApp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeDTO employeeDTO;
    private Department department;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        department = Department.builder().id(1L).name("HR").build();
        employee = Employee.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .position("Manager")
                .salary(60000.0)
                .department(department)
                .build();

        employeeDTO = new EmployeeDTO(1L,
                "John",
                "Doe",
                "Manager",
                60000.0,
                1L,
                null);
    }

    @Test
    public void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.getEmployeeById(1L);

        assertNotNull(foundEmployee);
        assertEquals("John", foundEmployee.getFirstName());
        assertEquals("Doe", foundEmployee.getLastName());
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));

        List<Employee> employees = employeeService.getAllEmployees();

        assertFalse(employees.isEmpty());
        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirstName());
    }

    @Test
    public void testSaveEmployee() {
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);

        assertNotNull(savedEmployee);
        assertEquals("John", savedEmployee.getFirstName());

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeCaptor.capture());
        assertEquals(department, employeeCaptor.getValue().getDepartment());
    }

    @Test
    public void testUpdateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee updatedEmployee = employeeService.updateEmployee(employeeDTO);

        assertNotNull(updatedEmployee);
        assertEquals("John", updatedEmployee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        employeeService.deleteEmployee(1L);
        verify(employeeRepository).deleteById(1L);
    }

    @Test
    public void testFindAllEmployeeProjectionByDepartmentId() {
        when(employeeRepository.findAllEmployeeProjectionByDepartmentId(1L)).thenReturn(List.of());

        List<DepartmentEmployees> projections = employeeService.findAllEmployeeProjectionByDepartmentId(1L);

        assertNotNull(projections);
        assertTrue(projections.isEmpty());
    }
}