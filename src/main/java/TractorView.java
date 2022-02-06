package main.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class TractorView extends JFrame
{
    CampDeText tfModel = new CampDeText(" Model");
    CampDeText tfPower = new CampDeText(" Power");
    JComboBox<Farmer> tfFarmer = new JComboBox((Vector)getFarmers());
    JButton btOk = new JButton("ADD NEW TRACTOR");

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa.farmer");
    EntityManager entityMgr = emfactory.createEntityManager();

    public TractorView ()
    {
        init();
    }

    private void addComponents ()
    {
        int x = 20;
        int y = 20;
        int compWidth = 250;
        int compHeight = 30;

        tfModel.setBounds(x, y, compWidth, compHeight);
        add(tfModel);

        y += 45;
        tfPower.setBounds(x, y, compWidth, compHeight);
        add(tfPower);

        y += 45;
        tfFarmer.setBounds(x, y, compWidth, compHeight);
        add(tfFarmer);

        y += 45;
        btOk.setBorder(new LineBorder(Color.BLACK,1));
        btOk.setBackground(new Color(154, 255, 191));
        btOk.setOpaque(true);
        btOk.isDefaultButton();
        btOk.setBounds(x, y, compWidth, compHeight);
        btOk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                add();
            }
        });
        add(btOk);
    }

    private List<Farmer> getFarmers()
    {
        Query q = entityMgr.createQuery("SELECT f FROM Farmer f");
        return q.getResultList();
    }

    private void init ()
    {
        config();
        addComponents();
        setVisible(true);
    }

    private void config ()
    {
        setTitle("Add Farmer");
        setLayout(null);
        setBounds(50, 300, 300, 250);
        setAutoRequestFocus(false);
    }
    
    private void add()
    {
        
        String name = tfModel.getText();
        String power = tfPower.getText();
        Farmer farmer = (Farmer) tfFarmer.getSelectedItem();

        Tractor newTractor = new Tractor();
        newTractor.setModel(name);
        newTractor.setPower(Integer.parseInt(power));
        newTractor.setFarmer(farmer);

        try
        {
            entityMgr.getTransaction().begin();
            entityMgr.persist(newTractor);
            entityMgr.getTransaction().commit();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

}
