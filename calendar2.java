// Starter Template
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.DefaultListModel;

public class calendar2 extends JFrame implements ActionListener{

  String fname="", lname="";
  String line=""; //variable to read each line from the data file
  String [] fields; // array to store the "split" line read
  int jersey=0;

  File source=new File("h:NewDataFile.txt");
  BufferedReader in=null; //variable representing the bufferedreader
  PrintWriter out=null; //variable representing the PrintWriter

  JPanel pmain = new JPanel();
  JPanel p0 = new JPanel();
  JPanel p1 = new JPanel();
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();
  JPanel p4 = new JPanel();


  JPanel right1 = new JPanel();

  DefaultListModel listmain = new DefaultListModel();
  JList list1 = new JList(listmain);
  JScrollPane scroll1 = new JScrollPane(list1);

  int dayint = 0;
  int monthint = 0;
  int teacherint = 0;

  String[] daytxt = {"Monday","Tuesday","Wensday","Thursday","Friday"};


  JLabel title = new JLabel("Newsletter Editor");

  JButton left = new JButton("<");
  JButton right = new JButton(">");

  JLabel day = new JLabel("Monday", SwingConstants.CENTER);
  JLabel teacherl = new JLabel("Teacher:");
  JLabel month_l = new JLabel("Month");
  JLabel event = new JLabel("Event");
  JLabel location = new JLabel ("Location");
  JLabel time = new JLabel ("Time");
  JLabel other = new JLabel("Other");
  JLabel logo = new JLabel("");

  JTextField event_t = new JTextField();
  JTextField location_t = new JTextField();
  JTextField time_t = new JTextField();
  JTextField other_t = new JTextField();

  JButton close = new JButton("Close");
  JButton add = new JButton("Add");
  JButton delete = new JButton("Delete");
  JButton edit = new JButton("Edit");

  String[] month = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
  String[] teacher = {"Moony","Desmaso","Vancardo","Chino"};
  JComboBox teacherbox = new JComboBox(teacher);
  JComboBox monthbox = new JComboBox(month);
  ImageIcon imgThisImg = new ImageIcon("moony.png");


  int t_index = 0;
  int m_index = 0;

  public static void main(String[ ] args)
  {
    new calendar2();
  }

  public calendar2 (){
    logo.setIcon(imgThisImg);

    teacherbox.setSelectedIndex(3);

    this.setTitle("Liam Crozier 2015");
    p1.setBorder(BorderFactory.createEmptyBorder(2,5,2,5));
    p3.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
    p4.setBorder(BorderFactory.createEmptyBorder(2,5,8,5));
    p0.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
    right1.setBorder(BorderFactory.createEmptyBorder(85,5,150,5));

    left.addActionListener(this);
    right.addActionListener(this);
    close.addActionListener(this);
    add.addActionListener(this);
    edit.addActionListener(this);
    delete.addActionListener(this);

    teacherbox.addActionListener(this);
    monthbox.addActionListener(this);

    pmain.setLayout(new BorderLayout());
    p0.setLayout(new BorderLayout(6,6));
    p1.setLayout(new GridLayout(2,1));
    p2.setLayout(new GridLayout(1,2));
    p3.setLayout(new GridLayout(1,3));
    p4.setLayout(new GridLayout(2,2));
    right1.setLayout(new GridLayout(6,2));

    pmain.add(p0,BorderLayout.CENTER);
    pmain.add(right1,BorderLayout.EAST);
    p0.add(p1,BorderLayout.NORTH);
    p0.add(p4,BorderLayout.SOUTH);
    p0.add(scroll1,BorderLayout.CENTER);

    p1.add(p2);
    p1.add(p3);

    p2.add(title);
    p2.add(logo);
    p3.add(left);
    p3.add(day);
    p3.add(right);


    p4.add(add);
    p4.add(delete);
    p4.add(edit);
    p4.add(close);


    right1.add(teacherl);
    right1.add(teacherbox);
    right1.add(month_l);
    right1.add(monthbox);
    right1.add(event);
    right1.add(event_t);
    right1.add(time);
    right1.add(time_t);
    right1.add(location);
    right1.add(location_t);
    right1.add(other);
    right1.add(other_t);

    listmain.addElement("A");
    listmain.addElement("B");



    this.add(pmain);

    this.setSize(550,420);
    this.setVisible(true);




    int monthint = monthbox.getSelectedIndex();
    int teacherint = teacherbox.getSelectedIndex();
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

    else if (e.getSource()==add)
    {
      listmain.addElement(event_t.getText() + ", " + time_t.getText() + ", " + location_t.getText() + ", " + other_t.getText());
      write();
    }

    else if (e.getSource()== delete)
    {
      if (list1.getSelectedIndex()>=0)
      {
        listmain.removeElementAt(list1.getSelectedIndex());
      }
      write();
    }

    else if (e.getSource()== edit)
    {
      if (list1.getSelectedIndex()>=0)
      {
        listmain.setElementAt(event_t.getText() + ", " + time_t.getText() + ", " + location_t.getText() + ", " + other_t.getText(), list1.getSelectedIndex());
      }
      write();
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

    else if (e.getSource()==close)
    {
      System.exit(1);
    }

    else if (e.getSource()==teacherbox)
    {
      t_index = teacherbox.getSelectedIndex();
      System.out.println(t_index);
      read();
    }

    else if (e.getSource()==monthbox)
    {
      m_index = monthbox.getSelectedIndex();
      System.out.println(m_index);
      read();
    }
  }











  public void read(){

    try
    {
      listmain.clear();
      in=new BufferedReader(new FileReader(teacher[t_index] + month[m_index] + daytxt[dayint] + ".txt"));
      System.out.println("File Opening");

      do
      {
        try{
        line=in.readLine();
        }
        catch (IOException e)
        {
          System.out.println("Problem reading data from file");
        }

        if (line!=null)
        {


            listmain.addElement(line);


        }
      } while (line!=null);
    }
    catch (FileNotFoundException e)
    {

      System.out.println("Problem opening File");
    }


    try
    {
      in.close();
      System.out.println("Closing File");
    }
    catch (IOException | NullPointerException e )
    {
      System.out.println("Problem Closing "+e);
    }

  }



  public void write(){

    try
    {
      out=new PrintWriter(new BufferedWriter(new FileWriter(teacher[t_index] + month[m_index] + daytxt[dayint] + ".txt", false)),true);
      System.out.println("File Opening");

      for (int i = 0; i<listmain.getSize();i++)
      {
        out.println(listmain.getElementAt(i));
        System.out.println("1");
      }


    }
    catch (IOException e)
    {
      System.out.println("Problem opening File");
    }


    System.out.println("Saving...");

    out.close();
    System.out.println("Closing File");

  }
}
