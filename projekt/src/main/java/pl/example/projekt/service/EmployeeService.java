package pl.example.projekt.service;

import org.springframework.stereotype.Service;
import pl.example.projekt.entity.Employee;
import pl.example.projekt.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//     endpoint, który pozwala na wyszukiwanie pracowników, którzy mają najwięcej spotkań w danym okresie czasu
    public List<Employee> getMostEngagedEmployees(Date fromDate, Date toDate) {
        return employeeRepository.findMostEngagedEmployees(fromDate, toDate);
    }
}
