package an.kondratev.departmentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(nullable = false, length = 150)
    private String lastName;

    @Column(nullable = false, length = 150)
    private String position;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false)
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnore
    private Department department;
}
