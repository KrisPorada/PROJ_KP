package pl.example.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data

public class RoomDto {

    private Long id;
    private String name;
    private Set<MeetingDto> meetings;


    public RoomDto(String name) {
        this.name = name;
    }
}