package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MainView extends JFrame
{

    Button btVillage = new Button("Add village");
    Button btFarmer = new Button("Add farmer");
    Button btTractor = new Button("Add tractor");
    Button btExit = new Button("Exit");

    public MainView ()
    {
        init();
    }

    private void addComponents ()
    {
        int x = 20;
        int y = 20;
        int compWidth = 250;
        int compHeight = 40;

        btVillage.setBounds(x, y, compWidth, compHeight);
        btVillage.addActionListener(new ActList());
        add(btVillage);

        y += 50;
        btFarmer.setBounds(x, y, compWidth, compHeight);
        btFarmer.addActionListener(new ActList());
        add(btFarmer);

        y += 50;
        btTractor.setBounds(x, y, compWidth, compHeight);
        btTractor.addActionListener(new ActList());
        add(btTractor);

        y += 50;
        btExit.setBounds(x, y, compWidth, compHeight);
        btExit.addActionListener(new ActList());
        add(btExit);

    }

    private void init ()
    {
        config();
        addComponents();
        setVisible(true);
    }

    private void config ()
    {
        setTitle("JPA - Hibernate");
        setLayout(null);
        setBounds(50, 300, 300, 250);
    }

    private static class Button extends JButton
    {
        public Button(String text)
        {
            super(text.toUpperCase());
            Font font = new Font(Font.SANS_SERIF,Font.BOLD,14);
            setFont(font);
        }
    }

    public class ActList implements ActionListener
    {

        @Override
        public void actionPerformed (ActionEvent event)
        {
            Button e = (Button) event.getSource();

            if (e.equals(btVillage)) new VillageView();
            if (e.equals(btFarmer)) new FarmerView();
            if (e.equals(btTractor)) new TractorView();
            if (e.equals(btExit)) System.exit(0);
        }
    }


}
