package pl.example.projekt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.example.projekt.entity.Room;
import pl.example.projekt.repository.RoomRepository;
import pl.example.projekt.service.RoomService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @Test
    void shouldReturnAllRooms() {
        Room room1 = new Room();
        room1.setName("Sala1");
        Room room2 = new Room();
        room2.setName("Sala2");

        List<Room> rooms = List.of(room1, room2);

        Mockito.when(roomRepository.findAll()).thenReturn(rooms);

        List<Room> result = roomService.getAllRooms();

        assertEquals(2, result.size());
        assertEquals("Sala1", result.get(0).getName());
        assertEquals("Sala2", result.get(1).getName());
    }
}


