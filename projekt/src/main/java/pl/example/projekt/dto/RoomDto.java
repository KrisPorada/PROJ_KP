package pl.example.projekt.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RoomDto {

    private Long id;
    private String name;
    private Set<MeetingDto> meetings;


}