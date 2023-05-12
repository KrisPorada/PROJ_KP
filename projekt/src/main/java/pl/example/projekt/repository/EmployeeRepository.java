package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.example.projekt.entity.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Endpoint, który pozwala na wyszukiwanie pracowników, którzy mają najwięcej spotkań w danym okresie czasu

    @Query("SELECT e, COUNT(m) as meetingsCount " +
            "FROM Employee e " +
            "JOIN e.meetings m " +
            "WHERE m.date >= :fromDate AND m.date <= :toDate " +
            "GROUP BY e " +
            "ORDER BY meetingsCount DESC")
    List<Employee> findMostEngagedEmployees(Date fromDate, Date toDate);
}
