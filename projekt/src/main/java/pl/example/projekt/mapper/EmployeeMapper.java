package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.example.projekt.dto.EmployeeDto;
import pl.example.projekt.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(target = "department", ignore = true),
            @Mapping(target = "meetings", ignore = true)
    })
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);
}
