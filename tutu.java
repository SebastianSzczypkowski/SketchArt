import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tutu extends JFrame implements ActionListener{



    JButton button = new JButton("Wybierz kolor");
    JButton clear = new JButton("wyczyść");
    JButton gumka = new JButton("gumka");
    JButton shape1 = new JButton("prostokąt");
    JButton shape2 = new JButton("pPełny");
    JButton shape3 = new JButton("elipsa");
    JButton shape4 = new JButton("ePełna");

    JSlider Size = new JSlider(JSlider.HORIZONTAL,0,25,25);
    boolean sh1 =false;
    boolean filledRectangle = false;
    boolean ellipse = false;
    boolean filledEllipse = false;



    //JFrame okno = new JFrame("SkatcheART");
    public int rozmiarPiora;
    private final paintWindow pW;
    Color c = Color.black;
    public int Framewidth = 1080,Frameheight = 720;

    public tutu() {



        ////////////////////////////////////////////
        pW = new paintWindow(this);
        add(pW);
        button.setBounds(10,10,160,20);
        button.addActionListener((ActionListener) this);
        add(button);
        clear.setBounds(180,10,160,20);
        add(clear);
        clear.addActionListener((ActionListener) this);
        gumka.setBounds(350,10,160,20);
        add(gumka);
        gumka.addActionListener((ActionListener)this);
        shape1.setBounds(700,10,80,20);
        add(shape1);
        shape1.addActionListener((ActionListener)this);
        shape2.setBounds(800,10,80,20);
        add(shape2);
        shape2.addActionListener((ActionListener)this);
        shape3.setBounds(900,10,80,20);
        add(shape3);
        shape3.addActionListener((ActionListener)this);
        shape4.setBounds(1000,10,80,20);
        add(shape4);
        shape4.addActionListener((ActionListener)this);


///////////////////////////////////////////////
        Size.setBounds(520,10,160,40);
        Size.setMinorTickSpacing(2);
        Size.setMajorTickSpacing(10);
        Size.setPaintTicks(true);
        Size.setPaintLabels(true);
        add(Size);
        Size.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rozmiarPiora = Size.getValue();
            }
        });

        //////////////////////////////////////////
        setSize(Framewidth, Frameheight);
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("SketchArt");

    }


    public void actionPerformed (ActionEvent e)
    {
            if(e.getSource()== button) {
                c = JColorChooser.showDialog(this, "Wybierz kolor", Color.black);
            }
            else if(e.getSource()== clear)
            {
                pW.clear();
            }
            else if(e.getSource()==gumka)
            {
                c=Color.white;
            }
            else if(e.getSource()==shape1)
            {
                sh1=true;

            }
            else if(e.getSource()==shape2)
            {
                sh1=true;
                filledRectangle=true;
            }
            else if(e.getSource()==shape3)
            {
                ellipse=true;
            }
            else if(e.getSource()==shape4)
            {
                ellipse=true;
                filledEllipse=true;

            }

    }

    public static void main(String args[]) {


        new tutu();
    }

}
