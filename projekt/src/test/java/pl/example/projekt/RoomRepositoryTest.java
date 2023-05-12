package pl.example.projekt;

import pl.example.projekt.repository.RoomRepository;
import pl.example.projekt.entity.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RoomRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void whenFindById_thenReturnRoom() {
        // given
        Room room = new Room();
        room.setName("Sala1");
        entityManager.persist(room);


        // when
        Optional<Room> found = roomRepository.findById(room.getId());

        // then
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getName()).isEqualTo(room.getName());
    }


}
