package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.projekt.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}