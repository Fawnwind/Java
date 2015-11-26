// Starter Template
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class calendar extends JFrame implements ActionListener{

  String fname="", lname="";
  String line=""; //variable to read each line from the data file
  String [] fields; // array to store the "split" line read
  int jersey=0;

  File source=new File("h:NewDataFile.txt");
  BufferedReader in=null; //variable representing the bufferedreader
  PrintWriter out=null; //variable representing the PrintWriter

  JPanel p0 = new JPanel();
  JPanel p1 = new JPanel();
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();
  JPanel p4 = new JPanel();

  int dayint = 0;

  String[] daytxt = {"Monday","Tuesday","Wensday","Thursday","Friday"};

  String[] fieldtxt = new String[10];

  JLabel title = new JLabel("Newsletter Editor");

  JButton left = new JButton("<");
  JButton right = new JButton(">");

  JLabel day = new JLabel("Monday", SwingConstants.CENTER);

  JLabel[] field = new JLabel[10];
  JTextField[] fill = new JTextField[10];
  JButton save = new JButton("Save");
  JButton close = new JButton("Close");

  public static void main(String[ ] args)
  {
    new calendar();
  }

  public calendar (){


    left.addActionListener(this);
    right.addActionListener(this);
    save.addActionListener(this);
    close.addActionListener(this);

    p0.setLayout(new BorderLayout(10,10));
    p1.setLayout(new GridLayout(2,1));
    p3.setLayout(new GridLayout(1,3));
    p4.setLayout(new GridLayout(11,2,0,6));

    p0.add(p1,BorderLayout.NORTH);
    p0.add(p4,BorderLayout.CENTER);
    p1.add(p2);
    p1.add(p3);

    p2.add(title);
    p3.add(left);
    p3.add(day);
    p3.add(right);

    for (int i=0;i<10;i++)
    {
      field[i] = new JLabel("Field "+ (i+1));
      p4.add(field[i]);

      fill[i] = new JTextField("");
      p4.add(fill[i]);
    }
    p4.add(save);
    p4.add(close);

    this.add(p0);

    this.setSize(500,420);
    this.setVisible(true);
    read();








  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource()==left)
    {
      if (dayint == 0){
        dayint = 4;

      }
      else{
        dayint = dayint -1;
      }
      day.setText(daytxt[dayint]);
      read();
    }
    else if (e.getSource()==right)
    {
      if (dayint == 4){
        dayint = 0;
      }
      else{
        dayint = dayint + 1;
      }
     day.setText(daytxt[dayint]);
     read();
    }
    else if (e.getSource()==save)
    {
      write();
    }
    else if (e.getSource()==close)
    {
      System.exit(1);
    }
  }











  public void read(){
    try
    {
      in=new BufferedReader(new FileReader(daytxt[dayint]+".txt"));
      System.out.println("File Opening");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Problem opening File");
    }

    for (int i=0;i<10;i++)
    {
      try{
        line=in.readLine();
      }
      catch (IOException e)
      {
        System.out.println("Problem reading data from file");
      }

      fill[i].setText(line);
      System.out.println(line);
    }
    System.out.print("Reading...");

    try
    {
      in.close();
      System.out.println("Closing File");
    }
    catch (IOException e)
    {
      System.out.println("Problem Closing "+e);
    }

  }



  public void write(){

    try
    {
      out=new PrintWriter(new BufferedWriter(new FileWriter(daytxt[dayint]+".txt", false)),true);
      // out=new PrintWriter(new BufferedWriter(new FileWriter(new File("h:NewDataFile.txt"), true)),true);
      // add ,true parameter to the FileWriter for opening as APPEND
      System.out.println("File Opening");
    }
    catch (IOException e)
    {
      System.out.println("Problem opening File");
    }

    for (int i=0;i<10;i++)
    {
      line = fill[i].getText();
      out.println(line);
    }
    System.out.println("Saving...");

    out.close();
    System.out.println("Closing File");

  }
}
