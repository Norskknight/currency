package persistence;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.ItemsItem;
import entity.Response;
import entity.StashesItem;
import org.hibernate.criterion.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class StashDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<ItemsItem> getItems() {
        List<ItemsItem> items = new ArrayList<ItemsItem>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            items = session.createCriteria(ItemsItem.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all items", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    public List<Response> getResponse() {

        Session session = null;
        List<Response> response = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            response = session.createCriteria(Response.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all items", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info("the resopnse"+ response);
        return response;
    }

    public List<StashesItem> getStashes() {
        List<StashesItem> stashes = new ArrayList<StashesItem>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            stashes = session.createCriteria(StashesItem.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all items", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return stashes;
    }
    /** save new response
     * @param response user to insert
     * @return id of the inserted user
     */
    public int insert(Response response) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(response);
            transaction.commit();
            for (StashesItem stash : response.getStashes()
                 ) {
                transaction = session.beginTransaction();
                session.saveOrUpdate(response.getNextChangeId(),stash);
                transaction.commit();
                for (ItemsItem item: stash.getItems()) {
                    transaction = session.beginTransaction();
                    session.saveOrUpdate(stash.getId(),item);
                    transaction.commit();
                    id++;
                }
                id++;
            }
            log.info(id);

        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user: " + response, he2);
                }
            }
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return id;
    }

    public List<ItemsItem> getPriceOfOrb(String orb) {
        List<ItemsItem> items = new ArrayList<ItemsItem>();;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria allItems = session.createCriteria(ItemsItem.class);
            Conjunction andExp = Restrictions.conjunction(Restrictions.like("frameType", 5),Restrictions.like("note", "%chaos%"),Restrictions.like("typeLine", "%Orb%"));
            log.info(andExp);
            allItems.add(andExp);
            log.info(allItems);
            items = allItems.list();
        } catch (HibernateException he) {
            log.error("Error getting all items", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    public Response setUpJson(String id) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.pathofexile.com/api/public-stash-tabs?"+id);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Response results = mapper.readValue(response, Response.class);
        return results;
    }

    public String getLastChangeID() {
        Response response = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria allIDs = session.createCriteria(Response.class);
            List ids = allIDs.list();
            response = (Response)(ids.get(0));

        } catch (HibernateException he) {
            log.error("Error getting all items", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return response.getNextChangeId();
    }

}
