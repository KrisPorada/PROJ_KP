package pl.example.projekt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Future(message = "Start time should be in the future")
    private LocalDateTime startTime;

    @NonNull
    @Future(message = "End time should be in the future")
    private LocalDateTime endTime;


    @Column(nullable = false)
    private LocalDateTime date; // Dodane pole date

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;



    @ManyToMany
    @JoinTable(
            name = "meeting_employee",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;
}
