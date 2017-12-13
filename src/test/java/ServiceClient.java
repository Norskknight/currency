import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Response;
import entity.StashesItem;
import org.junit.Test;
import persistence.StashDao;
import entity.*;
import persistence.UserDao;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;


import java.util.List;

import static org.junit.Assert.*;


public class ServiceClient {

    public Response setUpJson(String id) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.pathofexile.com/api/public-stash-tabs?"+id);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Response results = mapper.readValue(response, Response.class);
        assertNotNull(results);
        return results;
    }

    @Test
    public void listItemsTest() throws Exception {
        Response results = setUpJson("0");
        int result = results.getStashes().get(3).getItems().size();
        assertEquals(Integer.parseInt("15"),result);
    }
    @Test
    public void listStashTest() throws Exception {
        Response results = setUpJson("0");
        int result = results.getStashes().size();
        assertEquals(Integer.parseInt("615"),result);
    }

    @Test
    public void PoeApiJSON() throws Exception {
        Response results = setUpJson("0");
        StashesItem result = results.getStashes().get(3);
        assertEquals("Leap Slam",result.getItems().get(1).getTypeLine());
    }

    @Test
    public void getStashes() throws Exception {
        StashDao dao = new StashDao();
        assertNotNull("list",dao.getStashes());
    }
    @Test
    public void getItems() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson("0");
        dao.insert(results);
        assertNotNull("list",dao.getItems());
    }

    @Test
    public void insert() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson(dao.getLastChangeID());
        int data = dao.insert(results);
        assertNotNull("number",data);
    }

    @Test
    public void getResponse() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson("0");

        assertNotNull("next id",dao.getResponse().get(0).getNextChangeId());
    }
    @Test
    public void testPriceOfOrb()throws Exception {
        StashDao dao = new StashDao();
        List price = dao.getPriceOfOrb("'%orb%'");
        assertNotNull("???",price);
    }

    @Test
    public void testID() throws Exception {
        StashDao dao = new StashDao();
        String id = dao.getLastChangeID();


        assertNotNull("???",id);
    }

    @Test
    public void testNewUser() throws Exception {
        UserDao dao = new UserDao();
        boolean id = dao.register(new User("testid","testpass"));
        assertNotNull("???",id);
    }


}