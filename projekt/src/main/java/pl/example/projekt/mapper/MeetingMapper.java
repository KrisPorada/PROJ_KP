package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.example.projekt.dto.MeetingDto;
import pl.example.projekt.entity.Meeting;

@Mapper(componentModel = "spring")
public interface MeetingMapper {
    @Mappings({
            @Mapping(target = "room", ignore = true),
            @Mapping(target = "employees", ignore = true)
    })
    MeetingDto toDto(Meeting meeting);
    Meeting toEntity(MeetingDto meetingDto);
}