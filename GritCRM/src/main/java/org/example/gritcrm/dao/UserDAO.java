package org.example.gritcrm.dao;

import org.example.gritcrm.model.User;
import org.example.gritcrm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends GenericDAO<User, Integer> {
    public UserDAO() {
        super(User.class);
    }

    public User getUser(String username){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            List<User> users = query.getResultList();

            if (users.isEmpty()) {
                return null;
            }
            return users.getFirst();
        }catch (Throwable e){
            throw e;
        }
    }
}
