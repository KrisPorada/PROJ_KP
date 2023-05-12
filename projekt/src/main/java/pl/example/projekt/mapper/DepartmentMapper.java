package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.example.projekt.dto.DepartmentDto;
import pl.example.projekt.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mappings({
            @Mapping(target = "employees", ignore = true)
    })
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto departmentDto);
}