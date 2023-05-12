package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.projekt.entity.Meeting;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findAllByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(LocalDateTime start, LocalDateTime end);
}