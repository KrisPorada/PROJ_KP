package pl.example.projekt.mapper;


import org.mapstruct.Mapper;
import pl.example.projekt.dto.RoomDto;
import pl.example.projekt.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto toDto(Room room);
    Room toEntity(RoomDto roomDto);
}