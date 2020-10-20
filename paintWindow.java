import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class paintWindow extends JPanel implements MouseListener {

    private static int Width = 850;
    private static int Height = 550;
    private tutu parent;
    private Point startPoint;

   // private drawObject dO;

    private Image image;
    private Graphics2D g2d;

    ////
    private ArrayList<ColoredRectangle> coloredRectangles= new ArrayList<ColoredRectangle>();
    private ArrayList<ColoredRectangle> filledRectangles= new ArrayList<ColoredRectangle>();
    private ArrayList<ColoredEllipse> coloredEllipses= new ArrayList<ColoredEllipse>();
    private ArrayList<ColoredEllipse> filledEllipses= new ArrayList<ColoredEllipse>();
    private Rectangle shape;
    private Ellipse2D shape2;

///////////
    private int x,y,x2,y2;


    public paintWindow(tutu parent)
    {
        this.parent=parent;

        //MyMouseListener ml = new MyMouseListener();
        addMouseListener(this);



        setBounds(100,100,Width,Height);
        setBackground(Color.white);
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (parent.sh1 == true) {
                    int xr = Math.min(startPoint.x, e.getX());
                    int yr = Math.min(startPoint.y, e.getY());
                    int width = Math.abs(startPoint.x- e.getX());
                    int height = Math.abs(startPoint.y - e.getY());
                    shape.setBounds(xr, yr, width, height);
                   // g2d.drawRect(xr, yr, width, height);
                    repaint();

                }
                else if(parent.ellipse==true)
                {

                        double xr = Math.min(startPoint.x, e.getX());
                        double yr = Math.min(startPoint.y, e.getY());
                        double width = Math.abs(startPoint.x- e.getX());
                        double height = Math.abs(startPoint.y - e.getY());
                       // shape2= new Ellipse2D.Double(xr,yr,width,height);
                        shape2.setFrame(xr,yr,width,height);


                        repaint();
                }
                 else{
                x2 = e.getX();
                y2 = e.getY();
                if (g2d != null) {
                    g2d.drawLine(x, y, x2, y2);
                    g2d.setStroke(new BasicStroke(parent.rozmiarPiora));
                    repaint();
                    x = x2;
                    y = y2;
                      }


                }
            }
        });


    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        x=e.getX();
        y=e.getY();
        repaint();
        g2d.setColor(parent.c);
        if(parent.sh1==true) {
            startPoint = e.getPoint();
            shape = new Rectangle();
            repaint();
        }
         if(parent.ellipse==true)
         {
             startPoint = e.getPoint();
             shape2 = new Ellipse2D.Double();
             repaint();
         }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(parent.sh1==true) {
            if (shape.width != 0 || shape.height != 0) {
                addRectangle(shape);
            }

            shape = null;


        }
        if(parent.ellipse==true) {
            if(shape2.getWidth() !=0 || shape2.getHeight() !=0) {
                addEllipse(shape2);
            }
            shape2 = null;

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    protected void paintComponent(Graphics g)
    {
        ////////////////////////////////////
        super.paintComponent(g);
        Color foreground = parent.c;
        g.setColor( Color.BLACK );


        if (image == null) {
        image = createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
       g.drawImage(image, 0, 0, null);



            //////////////////////////////
            for (ColoredRectangle cr : coloredRectangles) {
                g.setColor(cr.getForeground());
                Rectangle r = cr.getRectangle();

                g.drawRect(r.x, r.y, r.width, r.height);
                //  g2d.setStroke(new java.awt.BasicStroke(3));

            }
            for (ColoredRectangle fr : filledRectangles) {
                g.setColor(fr.getForeground());
                Rectangle r = fr.getRectangle();

                g.fillRect(r.x, r.y, r.width, r.height);

                //  g2d.setStroke(new java.awt.BasicStroke(parent.rozmiarPiora));

            }
            for (ColoredEllipse ce : coloredEllipses) {
                g.setColor(ce.getForeground());
                Ellipse2D e = ce.getEllipse2D();

                //g2d.draw(new Ellipse2D.Double(e.getBounds().x, e.getBounds().y, startPoint.x-e.getBounds().x, startPoint.y-e.getBounds().y));
                g.drawOval((int) e.getX(), (int) e.getY(), (int) e.getWidth(), (int) e.getHeight());


                //  g2d.setStroke(new java.awt.BasicStroke(3));

            }
            for (ColoredEllipse ce : filledEllipses) {
                g.setColor(ce.getForeground());
                Ellipse2D e = ce.getEllipse2D();

                //g2d.draw(new Ellipse2D.Double(e.getBounds().x, e.getBounds().y, startPoint.x-e.getBounds().x, startPoint.y-e.getBounds().y));
                g.fillOval((int) e.getX(), (int) e.getY(), (int) e.getWidth(), (int) e.getHeight());


                //  g2d.setStroke(new java.awt.BasicStroke(3));

            }

            if (shape != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(foreground);
                g2d.setStroke(new BasicStroke(parent.rozmiarPiora));
                g2d.draw(shape);


            }
            if (shape2 != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(foreground);
                g2d.setStroke(new BasicStroke(parent.rozmiarPiora));
                g2d.draw(shape2);


            }





        //////////////////////////////////////


    }
    public void clear()
    {
        g2d.setPaint(Color.WHITE);
        g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.setPaint(Color.BLACK);
        coloredRectangles.clear();
        filledRectangles.clear();
        coloredEllipses.clear();
        filledEllipses.clear();
        repaint();
    }
    //////////////////////////////////////////////////////
    public void addRectangle(Rectangle rectangle)
    {
        ColoredRectangle cr = new ColoredRectangle(rectangle);
        ColoredRectangle fr = new ColoredRectangle(rectangle);
        coloredRectangles.add(cr);
        if(parent.filledRectangle==true)
        {
            filledRectangles.add(fr);
        }
        repaint();

        parent.sh1=false;
       parent.filledRectangle=false;
    }

    public void addEllipse(Ellipse2D ellipse2D)
    {
        ColoredEllipse ce = new ColoredEllipse(ellipse2D);
        coloredEllipses.add(ce);
        if(parent.filledEllipse==true)
        {
            filledEllipses.add(ce);
        }
        repaint();

        parent.ellipse=false;
        parent.filledEllipse=false;

    }

    public void clearR()
    {
        coloredRectangles.clear();
        filledRectangles.clear();
        repaint();
    }


    class ColoredRectangle
    {
        private Color foreground;
        private Rectangle rectangle;
        public ColoredRectangle(Rectangle rectangle)
        {
            this.foreground =parent.c;
            this.rectangle=rectangle;
        }
        public Color getForeground()
        {
            return foreground;
        }
        public void setForeground()
        {
            this.foreground=parent.c;
        }
        public Rectangle getRectangle()
        {
            return rectangle;
        }
    }

    class ColoredEllipse
    {
        private Color foreground;
        private Ellipse2D ellipse2D;
        public ColoredEllipse(Ellipse2D ellipse2D)
        {
            this.foreground =parent.c;
            this.ellipse2D=ellipse2D;
        }
        public Color getForeground()
        {
            return foreground;
        }
        public void setForeground()
        {
            this.foreground=parent.c;
        }
        public Ellipse2D getEllipse2D()
        {
            return ellipse2D;
        }
    }
}
