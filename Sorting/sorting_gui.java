
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.DefaultListModel;

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

  JComboBox sorting_pick_c = new JComboBox(sorting_t);
  JComboBox visual_c = new JComboBox("Yes","No");

  JButton gen_r = new JButton("Generate Numbers");
  JButton clear = new JButton("Clear Numbers");

  JLabel time = new JLabel("Time:");
  JLabel swap# = new JLabel("Number Of Swaps:");
  JLabel sorting_pick_l = new JLabel("Sorting Type:");
  JLabel visual_l = new JLabel("Visualize:")


  int[] numbers_r;






  public static void main(String[ ] args)
  {
    new sorting_gui();
  }

  public sorting_gui (){

    main.setLayout(new BorderLayout());
    list_p.setLayout(new GridLayout(1,2));
    right_p.setLayout(new GridLayout(2,2));
    //right_p.setLayout(new GridLayout(6,2));

    main.add(list_p,BorderLayout.CENTER);
    main.add(right_p,BorderLayout.EAST);

    right_p.add(sorting_pick_l);
    right_p.add(sorting_pick_c);
    right_p.add(visual_l);
    right_p.add(visual_c);
    right_p.add(gen_r);
    right_p.add(clear);
    right_p.add(time);
    right_p.add(swap#);

    this.add(main);
    this.setTitle("Liam Crozier 2015");
    this.setSize(500,500);
    this.setVisible(true);

  }

  public void actionPerformed(ActionEvent e)
  {

  }








/*
  public static void Bubble(){
    for (int m=listlen-1;m>=1;m--){
      flag=0;
      for (int n=0;n<m;n++){
        if (a[n+1]<a[n]){
          temp=a[n+1];
          a[n+1]=a[n];
          a[n]=temp;
          flag=1;
        }
      }
      if (flag==0){
        m=0;
      }
    }
  }

  public static void Insert(){
    b[0]=a[0];

    for (int m=1;m<listlen;m++){
      flag=0;
      for (int n=0;n<m;n++){

        if (a[m]<b[n]){
          flag=1;
          for (int o=m;o>n;o--){
            b[o]=b[o-1];
          }
          b[n]=a[m];
          n=m;
        }
      }
      if (flag==0)
        b[m]=a[m];
    }
  }

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




