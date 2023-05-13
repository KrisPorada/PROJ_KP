package pl.example.projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import pl.example.projekt.controller.RoomController;
import pl.example.projekt.dto.RoomDto;
import pl.example.projekt.entity.Room;
import pl.example.projekt.service.RoomService;

@SpringBootTest
public class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @Test
    public void getAllRoomsTest() {
        RoomDto room1 = new RoomDto("Sala2");
        RoomDto room2 = new RoomDto("Sala3");
//        when(roomService.getAllRooms()).thenReturn(Arrays.<Room>asList(room1, room2));

//        ResponseEntity<List<RoomDto>> result = roomController.getAllRooms();

//        assertEquals(2, result.getBody().size());
    }


}
