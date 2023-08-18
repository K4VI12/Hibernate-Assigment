package lk.ijse.thogakade.repository;

import lk.ijse.thogakade.config.SessionFactoryConfig;
import lk.ijse.thogakade.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public boolean saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(customer);
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

    public Customer getCustomer(String id) {
        try {
            Customer customer = session.get(Customer.class, id);
            session.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
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

    public boolean deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
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
