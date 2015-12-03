import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

public class sorting_gui extends JFrame implements ActionListener
{

	MyDrawPanel draw1=new MyDrawPanel();
	JPanel main = new JPanel();

  ball test = new ball();

	public static void main(String[ ] args)
  {

    try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
    catch (UnsupportedLookAndFeelException e) {}
    catch (ClassNotFoundException e) {}
    catch (InstantiationException e) {}
    catch (IllegalAccessException e) {}

    new Thread(new visual()).start();

  }

  public main()
  {
    System.out.print("test");
  }

  public void run()
  {

  }
}