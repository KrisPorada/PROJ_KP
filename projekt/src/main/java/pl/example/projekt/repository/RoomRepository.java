package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.projekt.entity.Room;

import java.time.LocalDateTime;

public interface RoomRepository extends JpaRepository<Room, Long> {

}