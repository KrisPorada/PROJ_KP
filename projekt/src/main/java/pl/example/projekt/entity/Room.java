package pl.example.projekt.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Room name cannot be null")  //walidacja czy nie pusta  nazwa
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,}",
            message = "Room name must have at least 3 characters and can contain only letters, digits and spaces")
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Meeting> meetings;
}
