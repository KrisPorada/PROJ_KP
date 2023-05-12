package pl.example.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private RoomDto room;
    private Set<EmployeeDto> employees;
}