package main.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPADemo
{

    public static void main (String[] args)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa.farmer");
        EntityManager entityMgr = emfactory.createEntityManager();

        try
        {
            entityMgr.getTransaction().begin();

            Village vila = new Village();
            vila.setDscVila("Sitges");
            vila.setExtensio(2983);
            vila.setHabitants(28);
            System.out.println(vila.toString());
            entityMgr.clear();

            System.out.println("Tot bé.");

            Farmer f1 = new Farmer();
            f1.setName("Pages1");
            f1.setVillage(vila);
            vila.addFarmer(f1);

            Tractor t1 = new Tractor();
            t1.setModel("model de tractor");
            t1.setPower(2000);
            t1.setFarmer(f1);
            f1.addTractor(t1);

            entityMgr.persist(vila);
            entityMgr.getTransaction().commit();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
