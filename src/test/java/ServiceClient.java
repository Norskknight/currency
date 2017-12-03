import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import stash.data.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;


import java.util.List;

import static org.junit.Assert.*;


public class ServiceClient {

    @Test
    public void PoeApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.pathofexile.com/api/public-stash-tabs");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response results = mapper.readValue(response, Response.class);
        StashesItem result = results.getStashes().get(3);
        assertEquals("Leap Slam",result.getItems().get(1).getTypeLine());
    }
}