package pl.example.projekt.service;

import org.springframework.stereotype.Service;
import pl.example.projekt.entity.Meeting;
import pl.example.projekt.repository.MeetingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Optional<Meeting> getMeeting(Long id) {
        return meetingRepository.findById(id);
    }

    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public void deleteMeeting(Long id) {
        meetingRepository.deleteById(id);
    }

    public Meeting updateMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }
}
