package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

interface ReservationRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingName(String bookingName);
}

@Entity
class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private String bookingName;
    private int groupSize;

    Booking() {}

    Booking(String bookingName, int groupSize) {
        this.bookingName = bookingName;
        this.groupSize = groupSize;
    }

    public Long getId() {
        return id;
    }

    public String getBookingName() {
        return bookingName;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
