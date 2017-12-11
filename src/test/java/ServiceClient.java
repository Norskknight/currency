import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Response;
import entity.StashesItem;
import org.junit.Test;
import persistence.StashDao;
import entity.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;


import static org.junit.Assert.*;


public class ServiceClient {

    public Response setUpJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.pathofexile.com/api/public-stash-tabs");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Response results = mapper.readValue(response, Response.class);
        return results;
    }
    @Test
    public void listItemsTest() throws Exception {
        Response results = setUpJson();
        int result = results.getStashes().get(3).getItems().size();
        assertEquals(Integer.parseInt("15"),result);
    }
    @Test
    public void listStashTest() throws Exception {
        Response results = setUpJson();
        int result = results.getStashes().size();
        assertEquals(Integer.parseInt("615"),result);
    }

    @Test
    public void PoeApiJSON() throws Exception {
        Response results = setUpJson();
        StashesItem result = results.getStashes().get(3);
        assertEquals("Leap Slam",result.getItems().get(1).getTypeLine());
    }

    @Test
    public void getStashes() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson();
        assertEquals("anything",dao.getStashes());
    }
    @Test
    public void getItems() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson();
        dao.insert(results);
        assertEquals("anything",dao.getItems());
    }

    @Test
    public void insert() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson();
        int data = dao.insert(results);
        assertEquals("anything",data);
    }

    @Test
    public void getResponse() throws Exception {
        StashDao dao = new StashDao();
        Response results = setUpJson();

        assertEquals("2524-4457-4108-4844-1428",dao.getResponse().get(0).getNextChangeId());
    }
}