import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Address address = new Address("sunita nagar","pune","maharashtra","2345");
        Customer customer = new Customer(1,"yash","paliwal",address);
        Session session = sessionFactory.openSession();
        session.save(customer);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        List<Customer> customerList = session.createQuery("from Customer").list();
        System.out.println(customerList);
        session.close();
    }
}
