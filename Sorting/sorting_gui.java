
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.Random;

public class sorting_gui extends JFrame implements ActionListener{

  JPanel main = new JPanel();
  JPanel list_p = new JPanel();
  JPanel right_p = new JPanel();

  DefaultListModel model_r = new DefaultListModel();
  JList list_r = new JList(model_r);
  JScrollPane scroll_r = new JScrollPane(list_r);

  DefaultListModel model_s = new DefaultListModel();
  JList list_s = new JList(model_s);
  JScrollPane scroll_s = new JScrollPane(list_s);

  String[] sorting_t = {"Bubble","Insert Selection","Quick Sort","Selection Exchange"};
  String[] visual_t = {"Yes","No"};

  JComboBox sorting_pick_c = new JComboBox(sorting_t);
  JComboBox visual_c = new JComboBox(visual_t);

  JButton gen_r = new JButton("Gen Numbers");
  JButton sort = new JButton("Sort Numbers");

  JLabel time = new JLabel("Time:");
  JLabel swap_l = new JLabel("# Of Swaps:");
  JLabel sorting_pick_l = new JLabel("Sorting Type:");
  JLabel visual_l = new JLabel("Visualize:");
  JLabel size_l = new JLabel("Size");
  JLabel range_l = new JLabel("Range");

  JTextField size_t = new JTextField("100");
  JTextField range_t = new JTextField("100");


  int[] numbers_r;
  int size = 100;
  int range = 100;
  int temp = 0;
  int flag = 0;





  public static void main(String[ ] args)
  {

    try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    }
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
    new sorting_gui();
  }

  public sorting_gui (){

    gen_r.addActionListener(this);
    sort.addActionListener(this);

    right_p.setBorder(BorderFactory.createEmptyBorder(10,3,80,3));
    list_p.setBorder(BorderFactory.createEmptyBorder(3,3,3,0));

    main.setLayout(new BorderLayout());
    list_p.setLayout(new GridLayout(1,2,3,3));
    right_p.setLayout(new GridLayout(6,2,3,3));

    Dimension right_d = new Dimension(250,300);
    right_p.setPreferredSize(right_d);


    main.add(list_p,BorderLayout.CENTER);
    main.add(right_p,BorderLayout.EAST);

    list_p.add(scroll_r);
    list_p.add(scroll_s);

    right_p.add(sorting_pick_l);
    right_p.add(sorting_pick_c);
    right_p.add(visual_l);
    right_p.add(visual_c);
    right_p.add(time);
    right_p.add(swap_l);
    right_p.add(size_l);
    right_p.add(size_t);
    right_p.add(range_l);
    right_p.add(range_t);
    right_p.add(gen_r);
    right_p.add(sort);

    this.add(main);
    this.setTitle("Liam Crozier 2015");
    this.setSize(650,270);
    this.setVisible(true);

    sort.setEnabled(false);

  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == gen_r)
    {
      sort.setEnabled(true);
      size = Integer.parseInt(size_t.getText());
      range = Integer.parseInt(range_t.getText());
      model_r.clear();
      numbers_r = new int[size];
      for (int i=0;i<size;i++)
      {
        Random r = new Random();
        numbers_r[i] = r.nextInt(range);
        model_r.addElement(numbers_r[i]);
      }
    }
    if (e.getSource() == sort)
    {

      model_s.clear();

      if (sorting_pick_c.getSelectedIndex() == 0)
      {
        model_s.addElement("Processing...");
        Bubble();
        model_s.clear();
      }
      else if (sorting_pick_c.getSelectedIndex() == 1)
      {
        model_s.addElement("Processing...");
        Insert();
        model_s.clear();
      }
      else if (sorting_pick_c.getSelectedIndex() == 2)
      {

      }
      else if (sorting_pick_c.getSelectedIndex() == 3)
      {

      }

      for (int i=0;i<size;i++)
      {
        model_s.addElement(numbers_r[i]);
      }
    }
  }









  public void Bubble(){

    for (int m=size-1;m>=1;m--){
      flag=0;
      for (int n=0;n<m;n++){
        if (numbers_r[n+1]<numbers_r[n]){
          temp=numbers_r[n+1];
          numbers_r[n+1]=numbers_r[n];
          numbers_r[n]=temp;
          flag=1;
        }
      }
      if (flag==0){
        m=0;
      }
    }
  }

  public void Insert(){
    int b[] = new int[size];
    for (int i=0;i<size;i++)
    {
      b[i] = numbers_r[i];
    }
    b[0]=numbers_r[0];

    for (int m=1;m<size;m++){
      flag=0;
      for (int n=0;n<m;n++){

        if (numbers_r[m]<b[n]){
          flag=1;
          for (int o=m;o>n;o--){
            b[o]=b[o-1];
          }
          b[n]=numbers_r[m];
          n=m;
        }
      }
      if (flag==0)
        b[m]=numbers_r[m];
    }
  }
/*
  public static void qsort(int a[], int start, int finish) {
    int lo = start;
    int hi = finish+1;
    int flag=0;

    if (lo >= hi) {
      return;
    }
    int pivot = a[lo];
    while (lo < hi) {
      flag=0;
      while (lo<hi && flag==0) {
        hi--;
        if (a[hi]<pivot){
          flag=1;
          a[lo]=a[hi];
        }

      }
      flag=0;
      while (lo<hi && flag==0) {
        lo++;
        if (a[lo]>pivot){
          flag=1;
          a[hi]=a[lo];
        }
      }
    }
    if (lo==hi)
    {
      a[hi]=pivot;
    }
    qsort(a, start, lo-1);
    qsort(a, hi+1, finish);
  }

  public static void SelectEx(){
    for (int n=0;n<listlen;n++){
    lowest=a[n];
    lowpos=n;
    for (int m=n+1;m<listlen;m++){
      if (a[m]<lowest){
        lowest=a[m];
        lowpos=m;
      }
    }
    temp=a[n];
    a[n]=a[lowpos];
    a[lowpos]=temp;
    }
  }*/
}




