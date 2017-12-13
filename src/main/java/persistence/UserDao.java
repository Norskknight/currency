package persistence;

import entity.User;
import entity.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public boolean register(User user){
        Transaction transaction = null;
        Session session = null;
        if(isUserExists(user)) return false;

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
            session.close();
        }
        return true;
    }

    public boolean isUserExists(User user){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        boolean result = false;
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
            User u = (User)query.uniqueResult();
            tx.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
}