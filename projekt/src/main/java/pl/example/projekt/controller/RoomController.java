package pl.example.projekt.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.projekt.dto.RoomDto;
import pl.example.projekt.entity.Room;
import pl.example.projekt.service.RoomService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        return roomService.getRoom(id)
                .map(room -> new ResponseEntity<>(room, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//        @PostMapping
//    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
//        return new ResponseEntity<>(roomService.saveRoom(room), HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room newRoom = roomService.createRoom(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(id, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//
//    @PutMapping("/{id}")
//    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
//        room.setId(id);
//        return new ResponseEntity<>(roomService.updateRoom(room), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoom(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


//    Endpoint do wyszukiwania wolnych sal w określonym czasie
    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                        @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return new ResponseEntity<>(roomService.getAvailableRooms(start, end), HttpStatus.OK);
    }

}
