package lk.ijse.thogakade.repository;

import lk.ijse.thogakade.config.SessionFactoryConfig;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemRepository {

    private final Session session;

    public ItemRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public boolean saveItem(Item item) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(item);
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

    public Item getItem(String code) {
        try {
            Item item = session.get(Item.class, code);
            session.close();
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateItem(Item item) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
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

    public boolean deleteItem(Item item) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(item);
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
