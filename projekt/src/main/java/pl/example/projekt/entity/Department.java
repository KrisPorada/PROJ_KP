package pl.example.projekt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "[a-zA-Z]{3,}", message = "Department name must consist of at least 3 letters")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
