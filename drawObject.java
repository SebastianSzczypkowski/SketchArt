import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
public class drawObject extends JPanel
{
    paintWindow pW;
    tutu parent;
    private ArrayList<ColoredRectangle> coloredRectangles= new ArrayList<ColoredRectangle>();
    private Rectangle shape;

    public drawObject()
    {

        this.pW=pW;
        MyMouseListener ml = new MyMouseListener();
        addMouseListener(ml);

        addMouseMotionListener(ml);

       setBounds(100,100,Width,Height);
       setBackground(Color.white);


    }


    protected void paintComponent(Graphics g) {
        ////////////////////////////////////
        super.paintComponent(g);
        Color foreground = Color.BLACK;
        g.setColor(Color.BLACK);


        //////////////////////////////

        for (ColoredRectangle cr : coloredRectangles) {
            g.setColor(cr.getForeground());
            Rectangle r = cr.getRectangle();
            g.drawRect(r.x, r.y, r.width, r.height);
        }

        if (shape != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(foreground);
            g2d.draw(shape);
        }
    }
    public void addRectangle(Rectangle rectangle)
    {
        ColoredRectangle cr = new ColoredRectangle(rectangle);
        coloredRectangles.add(cr);
        repaint();
    }

    public void clearR()
    {
        coloredRectangles.clear();
        repaint();
    }

    class MyMouseListener extends MouseInputAdapter
    {
        private Point startPoint;

        public void mousePressed(MouseEvent e)
        {
            startPoint = e.getPoint();
            shape = new Rectangle();
        }

        public void mouseDragged(MouseEvent e) {

                int x = Math.min(startPoint.x, e.getX());
                int y = Math.min(startPoint.y, e.getY());
                int width = Math.abs(startPoint.x - e.getX());
                int height = Math.abs(startPoint.y - e.getY());

                shape.setBounds(x, y, width, height);
                repaint();



            }
        }

        public void mouseReleased(MouseEvent e)
        {
            if (shape.width != 0 || shape.height != 0)
            {
                addRectangle(shape);
            }

            shape = null;
        }
    }
    class ColoredRectangle
    {
        private Color foreground;
        private Rectangle rectangle;
        public ColoredRectangle(Rectangle rectangle)
        {
            this.foreground =Color.BLACK;
            this.rectangle=rectangle;
        }
        public Color getForeground()
        {
            return foreground;
        }
        public void setForeground()
        {
            this.foreground=Color.BLACK;
        }
        public Rectangle getRectangle()
        {
            return rectangle;
        }
    }


*/

