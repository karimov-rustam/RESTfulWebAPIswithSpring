package demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = Application.class,
        loader = SpringApplicationContextLoader.class)
public class ApplicationTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(
                "the reservationRepository should be non-null",
                this.reservationRepository);
    }

    @Test
    public void testFindByBookingName() {
        Assert.assertTrue(
                "There should be one record with the booking name 'karimov'",
                this.reservationRepository.findByBookingName("karimov").size() == 1);
    }

    @Test
    public void testLoadingResultsInDatabase() {
        List<Booking> bookingList =
                this.reservationRepository.findAll();
        Assert.assertNotNull(
                "There must be a response",
                bookingList);
        Assert.assertTrue(
                "There must be at least one result",
                bookingList.size() > 0);
    }
}