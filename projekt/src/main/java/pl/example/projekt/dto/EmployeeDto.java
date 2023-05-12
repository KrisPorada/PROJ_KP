package pl.example.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class EmployeeDto {
        private Long id;
        private String name;
//        private DepartmentDto department;
//        private Set<MeetingDto> meetings;
    }

