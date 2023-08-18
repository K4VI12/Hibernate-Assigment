package lk.ijse.thogakade.repository;

import lk.ijse.thogakade.config.SessionFactoryConfig;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderRepository {

    private final Session session;

    public OrderRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public boolean saveOrders(Orders orders) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(orders);
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

    public Orders getOrders(String orderId) {
        try {
            Orders orders = session.get(Orders.class, orderId);
            session.close();
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateOrders(Orders orders) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(orders);
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

    public boolean deleteOrders(Orders orders) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(orders);
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
