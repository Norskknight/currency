package persistence;

import control.UserItem;
import entity.User;
import entity.UserRole;
import entity.Useritems;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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


}