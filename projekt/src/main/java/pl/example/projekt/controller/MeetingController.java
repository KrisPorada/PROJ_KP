package pl.example.projekt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.projekt.entity.Meeting;
import pl.example.projekt.service.MeetingService;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        return new ResponseEntity<>(meetingService.getAllMeetings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeeting(@PathVariable Long id) {
        return meetingService.getMeeting(id)
                .map(meeting -> new ResponseEntity<>(meeting, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        return new ResponseEntity<>(meetingService.saveMeeting(meeting), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> updateMeeting(@PathVariable Long id, @RequestBody Meeting meeting) {
        meeting.setId(id);
        return new ResponseEntity<>(meetingService.updateMeeting(meeting), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
