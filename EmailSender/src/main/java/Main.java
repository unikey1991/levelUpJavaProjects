import view.MainFrame;

/**
 * Created by unike on 03.05.2017.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*SessionFactory sessionFactory = getSessionFactory();

        try (Session session = sessionFactory.openSession()) {


//            User user = new User("email", "pass", "name", "lastname", AccountType.ADMIN);
//
//            Transaction transaction = session.getTransaction();
//            transaction.begin();
//            session.save(user);
//            transaction.commit();

            Transaction transaction = session.getTransaction();
            transaction.begin();
            File file = new File("111.csv");
            Packet packet = new Packet("her1", new Date(), null, null, file);
            session.save(packet);
            transaction.commit();


        } finally {
            sessionFactory.close();
            System.out.println("session closed");
        }*/

        MainFrame mainFrame = new MainFrame();
        mainFrame.setLocationRelativeTo(null);


    }
}
