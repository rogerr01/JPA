package main.java;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CampDeText extends JTextField
{
    public CampDeText (final String proptText)
    {
        super(proptText);
        setBorder(new LineBorder(Color.BLACK,1));

        addFocusListener(new FocusListener()
        {

            @Override
            public void focusLost (FocusEvent e)
            {
                if (getText().isEmpty())
                {
                    setText(proptText);
                }
            }

            @Override
            public void focusGained (FocusEvent e)
            {
                if (getText().equals(proptText))
                {
                    setText("");
                }
            }
        });

    }

}
