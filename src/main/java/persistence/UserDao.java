package persistence;

import entity.User;
import entity.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public boolean register(User user){

        if(isUserExists(user)) return false;
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

    public boolean isUserExists(User user){
        Session session = null;
        boolean result = false;
        Transaction transaction = null;
        try{
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
            User u = (User)query.uniqueResult();
            transaction.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
}