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
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class FarmerView extends JFrame
{
    CampDeText tfDesc = new CampDeText(" Name");
    JComboBox<Village> tfVillage = new JComboBox((Vector) getVillages());
    JButton btOk = new JButton("ADD NEW FARMER");

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa.farmer");
    EntityManager entityMgr = emfactory.createEntityManager();

    public FarmerView ()
    {
        init();
    }

    private void addComponents ()
    {
        int x = 20;
        int y = 20;
        int compWidth = 250;
        int compHeight = 30;

        tfDesc.setBounds(x, y, compWidth, compHeight);
        add(tfDesc);

        y += 45;
        tfVillage.setBounds(x, y, compWidth, compHeight);
        add(tfVillage);

        y += 45;
        btOk.setBorder(new LineBorder(Color.BLACK,1));
        btOk.setBackground(new Color(154, 255, 191));
        btOk.setOpaque(true);
        btOk.isDefaultButton();
        btOk.setBounds(x, y, compWidth, compHeight);
        btOk.addActionListener((e) -> {add();});
        add(btOk);
    }

    private List<Village> getVillages()
    {
        Query q = entityMgr.createQuery("SELECT v FROM Village v");
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
        
        String name = tfDesc.getText();
        Village village = (Village) tfVillage.getSelectedItem();
        
        Farmer newFarmer = new Farmer();
        newFarmer.setName(name);
        newFarmer.setVillage(village);

        try
        {
            entityMgr.getTransaction().begin();
            entityMgr.persist(newFarmer);
            entityMgr.getTransaction().commit();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

}
