package main.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VillageView extends JFrame
{
    CampDeText tfDesc = new CampDeText(" Name");
    CampDeText tfPop = new CampDeText(" Population");
    CampDeText tfExt = new CampDeText(" Extension");
    JButton btOk = new JButton("ADD NEW VILLAGE");


    public VillageView ()
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
        tfPop.setBounds(x, y, compWidth, compHeight);
        add(tfPop);

        y += 45;
        tfExt.setBounds(x, y, compWidth, compHeight);
        add(tfExt);

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

    private void init ()
    {
        config();
        addComponents();
        setVisible(true);
    }

    private void config ()
    {
        setTitle("Add village");
        setLayout(null);
        setBounds(50, 300, 300, 250);
        setAutoRequestFocus(false);
    }

    private void add()
    {

        String name = tfDesc.getText();
        String population = tfPop.getText();
        String extension = tfExt.getText();

        Village newVillage = new Village();
        newVillage.setDscVila(name);
        newVillage.setHabitants(Integer.parseInt(population));
        newVillage.setExtensio(Integer.parseInt(extension));

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa.farmer");
        EntityManager entityMgr = emfactory.createEntityManager();

        try
        {
            entityMgr.getTransaction().begin();
            entityMgr.persist(newVillage);
            entityMgr.getTransaction().commit();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
