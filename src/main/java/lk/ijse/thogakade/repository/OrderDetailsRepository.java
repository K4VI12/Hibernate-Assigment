package lk.ijse.thogakade.repository;

import lk.ijse.thogakade.config.SessionFactoryConfig;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.orderdetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDetailsRepository {

    private final Session session;

    public OrderDetailsRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public boolean saveOrderDetails(orderdetail orderd) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(orderd);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public orderdetail getOrderDetails(String id) {
        try {
            orderdetail orderd = session.get(orderdetail.class, id);
            session.close();
            return orderd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateOrderDetails(orderdetail orderd) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(orderd);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOrderDetails(orderdetail orderd) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(orderd);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

}
