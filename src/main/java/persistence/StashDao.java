package persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import stash.data.ItemsItem;
import stash.data.StashesItem;

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

}
