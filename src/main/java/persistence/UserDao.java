package persistence;

import entity.ItemsItem;
import entity.User;
import entity.UserRole;
import entity.Useritems;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public boolean register(User user) {

        if (isUserExists(user)) return false;
        Transaction transaction = null;
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            transaction = session.beginTransaction();
            session.saveOrUpdate(new UserRole(user));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            assert session != null;
            session.flush();
            session.close();
        }
        return true;
    }

    public boolean isUserExists(User user) {
        Session session = null;
        boolean result = false;
        Transaction transaction = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where userId='" + user.getUserId() + "'");
            User u = (User) query.uniqueResult();
            transaction.commit();
            if (u != null) result = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public long getUserId(String userId) {
        Session session = null;
        Transaction transaction = null;
        User u = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query;
            String queryText = "from User where userId='" + userId + "'";
            query = session.createQuery(queryText);
            log.info(query);
            u = (User) query.uniqueResult();

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();

        }

        return u.getId();
    }

    public boolean addUserItem(Useritems item) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            log.info("before"+item);
            session.saveOrUpdate(item);
            log.info("after"+item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();

        }
    return true;
    }

    public List<ItemsItem> getUserItems(long userId){
        List<ItemsItem> items = null;
        Session session = null;
        Transaction transaction = null;
        StashDao stashDao = new StashDao();
        List<ItemsItem> items2 = new ArrayList<>();
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();


            Query query;
            String queryText = "from Useritems where userid=" + userId;
            query = session.createQuery(queryText);
            log.info(query);
            List Useritems = query.list();
            log.info(Useritems);
            transaction.commit();

            for (Object userItem: Useritems) {
                entity.Useritems itemname = (Useritems)userItem;

                log.info(itemname);
                String itemName = itemname.getItemname();
                log.info(itemName);
                transaction = session.beginTransaction();
                Query query2;
                String queryText2 ="from ItemsItem where note like '%chaos%' and typeLine like '%"+itemName+"%'";
                query2 = session.createQuery(queryText2);
                log.info(query2);
                List itemsSelect = query2.list();
                log.info(itemsSelect);
                items2.addAll(itemsSelect);
                log.info(items2);
                transaction.commit();
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();

        }
        log.info(items2);
        return items2;
    }
}