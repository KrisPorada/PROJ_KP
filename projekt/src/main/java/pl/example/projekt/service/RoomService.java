package pl.example.projekt.service;
import org.springframework.stereotype.Service;
import pl.example.projekt.entity.Meeting;
import pl.example.projekt.entity.Room;
import pl.example.projekt.repository.MeetingRepository;
import pl.example.projekt.repository.RoomRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final MeetingRepository meetingRepository;

    public RoomService(RoomRepository roomRepository, MeetingRepository meetingRepository) {
        this.roomRepository = roomRepository;
        this.meetingRepository = meetingRepository;
    }




    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAvailableRooms(LocalDateTime start, LocalDateTime end) {
        //  wszystkie pokoje
        List<Room> allRooms = roomRepository.findAll();

        //  wszystkie spotkania, które odbywają się w określonym czasie
        List<Meeting> meetings = meetingRepository.findAllByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(start, end);

        //  pokoje, które są używane do spotkań
        List<Room> occupiedRooms = meetings.stream()
                .map(Meeting::getRoom)
                .collect(Collectors.toList());

        // Usuń zajęte pokoje z listy wszystkich pokoi
        allRooms.removeAll(occupiedRooms);

        return allRooms;
    }


}
