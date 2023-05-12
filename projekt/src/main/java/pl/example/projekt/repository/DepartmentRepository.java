package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.projekt.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
