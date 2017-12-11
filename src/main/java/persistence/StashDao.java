package persistence;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.ItemsItem;
import entity.Response;
import entity.StashesItem;
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

    public int insertResponce(Response response) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            log.info("the response :"+response);
            session.saveOrUpdate(response);
            transaction.commit();
            id++;
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
                session.close();
            }
        }
        return id;
    }
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


}
