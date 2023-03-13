package test.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.Location;
import main.java.service_system.common.hibernate.dao.LocationDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Tests database queries for the "location" table using an in-memory H2 database.
 *
 * Created by skeane on 3/3/2023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../resources/test-context.xml")
public class LocationDAOImplTest extends TestCase {

    @Autowired
    private LocationDAO locationDAO;

    private Location location1;
    private Location location2;
    private Location location3;

    @Before
    public void init() {
        location1 = new Location(1, "Shrine", "80-1 Motohakone, Hakone, Ashigarashimo District, Kanagawa 250-0522, Japan", "Park anywhere.");
        location2 = new Location(2, "PA", "15 Daikokufutō, Tsurumi Ward, Yokohama, Kanagawa 230-0054, Japan", "Park next to the conbini.");
        location3 = new Location(1, "Home", "2-27-18 Seta, Setagaya-ku, Tokyo", "Park in spot 3.");
    }

    @Test
    public void testSave() {
        locationDAO.save(location1);
        locationDAO.save(location2);

        List<Location> result = locationDAO.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindByUserId() {
        locationDAO.save(location1);
        locationDAO.save(location2);
        locationDAO.save(location3);

        List<Location> result = locationDAO.findByUserId(location3.getUserId());
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteById() {
        locationDAO.save(location1);
        locationDAO.save(location2);
        locationDAO.save(location3);

        locationDAO.deleteById(location2.getId());

        List<Location> result = locationDAO.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdate() {
        locationDAO.save(location1);
        locationDAO.save(location2);

        Location update = locationDAO.findOne(location1.getId());
        update.setName("Hakone Shrine");
        update.setDetails("Park in spot 1.");

        locationDAO.update(update);

        Location result = locationDAO.findOne(update.getId());

        assertEquals(update.getId(), result.getId());
        assertEquals(update.getUserId(), result.getUserId());
        assertEquals(update.getName(), result.getName());
        assertEquals(update.getAddress(), result.getAddress());
        assertEquals(update.getDetails(), result.getDetails());
    }

}
