import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import persistence.StashDao;
import stash.data.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;


import java.util.List;

import static org.junit.Assert.*;


public class ServiceClient {

    public Response setUpJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.pathofexile.com/api/public-stash-tabs");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
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
        assertEquals("anything",dao.getStashes());
    }
    @Test
    public void getItems() throws Exception {
        StashDao dao = new StashDao();
        assertEquals("anything",dao.getItems());
    }
}