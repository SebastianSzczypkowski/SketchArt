import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {

    JButton ok = new JButton("Ok");
    JLabel w =new JLabel("Szerokość okna roboczego:");
    JLabel h =new JLabel("Wysokość okna roboczego:");
    public Start()
    {

        ok.setBounds(240,230,160,20);
        ok.addActionListener((ActionListener)this);
        add(ok);
        w.setBounds(20,20,160,20);
        add(w);
        h.setBounds(20,40,160,20);
        add(h);




        setSize(640,480);
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("StartPanel");


    }
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==ok)
        {
            new tutu();
        }
    }


}
