import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class oop extends JFrame implements ActionListener,Runnable
{
  Image backImage;
  private Image dbImage;
  private Graphics dbg;
  JPanel main = new JPanel();
  int posX = 0;
  int posY = 0;
  int speedx = 0;
  int speedy = 0;

  ball[] balls = new ball[1000];
  MyDrawPanel draw1=new MyDrawPanel();

  public static void main(String[ ] args)
  {

    try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
    catch (UnsupportedLookAndFeelException e) {}
    catch (ClassNotFoundException e) {}
    catch (InstantiationException e) {}
    catch (IllegalAccessException e) {}

    new Thread(new oop()).start();

  }

  public oop()
  {

  	this.addMouseListener(new MouseAdapter()
{
   public void mousePressed(MouseEvent e)
   {
      posX=e.getX();
      posY=e.getY();
   }
});
  	this.addMouseMotionListener(new MouseAdapter()
{
     public void mouseDragged(MouseEvent evt)
     {
		//sets frame position when mouse dragged
		setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);

     }
});
  	this.setUndecorated(true);
    System.out.print(balls.length);
    this.add(draw1);
    this.setSize(300,300);
    this.setVisible(true);

    for (int i=0;i<balls.length;i++)
    {
      int rx = (int)(Math.random()*(250-10)+0);
      int ry = (int)(Math.random()*(250-10)+0);
      int rc = (int)(Math.random()*(5)+0);
      int rs =(int)(Math.random()*(20)+1);

      balls[i] = new ball();
      balls[i].start(rx,ry,rs,rc);
    }
    for (int i=0;i<balls.length;i++)
    {
      do
      {
        speedx=(int)(Math.random()*(4)-2);
        speedy=(int)(Math.random()*(4)-2);
      }while (speedx ==0 || speedy ==0);

      balls[i].speed(speedx,speedy);
    }

  }




  public void run()
  {
    while (1!=100000000)
    {
      try{Thread.sleep(10);}
      catch(InterruptedException ex){}
      for (int i=0;i<balls.length;i++)
      {
        if (balls[i].getxpos() > 300)
        {

          int j = balls[i].getxspeed();
          balls[i].speedchangex(j*-1);

        } else if (balls[i].getxpos() == 0)
        {
          int j = balls[i].getxspeed();
          balls[i].speedchangex(j*-1);
        }
        if (balls[i].getypos() > 300) {
        	int j = balls[i].getyspeed();
          balls[i].speedchangey(j*-1);
        } else if (balls[i].getypos() == 0) {
          int j = balls[i].getyspeed();
          balls[i].speedchangey(j*-1);
        }
        balls[i].move();
      }
      repaint();
    }


  }

  class MyDrawPanel extends JPanel
  {
    public void paint(Graphics g2)
    {
      Graphics2D g3 = (Graphics2D)g2;
    g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g3.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      for (int i=0;i<balls.length;i++)
      {
        if (balls[i].getcolor()==1)
        {
          g2.setColor(Color.CYAN);
        }
        else if (balls[i].getcolor()==2)
        {
          g2.setColor(Color.BLUE);
        }
        else if (balls[i].getcolor()==3)
        {
          g2.setColor(Color.GREEN);
        }
        else if (balls[i].getcolor()==4)
        {
          g2.setColor(Color.ORANGE);
        }
        else if (balls[i].getcolor()==5)
        {
          g2.setColor(Color.MAGENTA);
        }
        else
        {
          g2.setColor(Color.DARK_GRAY);
        }
        g2.fillOval(balls[i].getxpos(),balls[i].getypos(),balls[i].getsizes(),balls[i].getsizes());
      }
    }
  }
  /*public void update(Graphics paramGraphics)
   {
   if (dbImage == null)
   {
   dbImage = createImage(getSize().width, getSize().height);
   dbg = dbImage.getGraphics();
   }
   dbg.setColor(getBackground());
   dbg.fillRect(0, 0, getSize().width, getSize().height);

   dbg.setColor(getForeground());
   paint(dbg);

   paramGraphics.drawImage(dbImage, 0, 0, this);
   }
   */
  public void actionPerformed(ActionEvent e)
  {

  }
}