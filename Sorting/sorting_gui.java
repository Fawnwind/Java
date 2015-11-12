
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
  JPanel right_m = new JPanel();
  JPanel right_t = new JPanel();


  DefaultListModel model_r = new DefaultListModel();
  JList list_r = new JList(model_r);
  JScrollPane scroll_r = new JScrollPane(list_r);

  DefaultListModel model_s = new DefaultListModel();
  JList list_s = new JList(model_s);
  JScrollPane scroll_s = new JScrollPane(list_s);

  String[] sorting_t = {"Bubble","Insert Selection","Quick Sort","Selection Exchange","Merge Sort"};
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

  Font font = new Font("Soge UI",Font.PLAIN,11);

  JTextArea merge_t = new JTextArea("The Mergesort algorithm can be used to sort a collection of objects. Mergesort is so called divide and conquer algorithm. Divide and conquer algorithms divide the original data into smaller sets of data to solve the problem.");


  int[] numbers_r;
  int[] helper;
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

    merge_t.setLineWrap(true);
    merge_t.setWrapStyleWord(true);
    merge_t.setFont(font);
    merge_t.setEditable(false);

    gen_r.addActionListener(this);
    sort.addActionListener(this);

    right_p.setBorder(BorderFactory.createEmptyBorder(10,3,0,3));
    list_p.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
    right_t.setBorder(BorderFactory.createEmptyBorder(6,0,6,6));

    main.setLayout(new BorderLayout());
    list_p.setLayout(new GridLayout(1,2,3,3));
    right_p.setLayout(new GridLayout(5,2,3,3));
    right_m.setLayout(new GridLayout(2,1,3,0));
    right_t.setLayout(new GridLayout(1,1));


    Dimension right_d = new Dimension(250,300);
    right_p.setPreferredSize(right_d);


    main.add(list_p,BorderLayout.CENTER);
    main.add(right_m,BorderLayout.EAST);

    list_p.add(scroll_r);
    list_p.add(scroll_s);

    right_m.add(right_p);
    right_m.add(right_t);

    right_t.add(merge_t);

    right_p.add(sorting_pick_l);
    right_p.add(sorting_pick_c);
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
      helper = new int[size];
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

      if (sorting_pick_c.getSelectedIndex()==0)
      {
        Bubble();
      }
      else if (sorting_pick_c.getSelectedIndex()==1)
      {
        Insert();
      }
      else if (sorting_pick_c.getSelectedIndex()==2)
      {
        //qsort(numbers_r,0,/*numbers_r.length*/100);
        //for (int i=0;i<size;i++)
        //{
          //model_s.addElement(numbers_r[i]);
        //}
      }
      else if (sorting_pick_c.getSelectedIndex()==3)
      {
        SelectEx();
      }
      else if (sorting_pick_c.getSelectedIndex()==4)
      {
        mergesort(0,size-1);
        for (int i=0;i<size;i++)
        {
          model_s.addElement(numbers_r[i]);
        }
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
    for (int i=0;i<size;i++)
    {
      model_s.addElement(numbers_r[i]);
    }
  }

  public void Insert(){
    int[] b = new int[size];

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
    for (int i=0;i<size;i++)
    {
      model_s.addElement(b[i]);
    }
  }

  public void mergesort(int low, int high) {
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergesort(low, middle);
      mergesort(middle + 1, high);
      merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high) {

    for (int i = low; i <= high; i++) {
      helper[i] = numbers_r[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers_r[k] = helper[i];
        i++;
      } else {
        numbers_r[k] = helper[j];
        j++;
      }
      k++;
    }
    while (i <= middle) {
      numbers_r[k] = helper[i];
      k++;
      i++;
    }
  }


  public static void qsort(int a[], int start, int finish) {
    int lo = start;
    int hi = finish;
    int flag = 0;

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

  public  void SelectEx(){
    int lowpos = 0;
    int lowest = 0;
    for (int n=0;n<size;n++){
    lowest=numbers_r[n];
    lowpos=n;
    for (int m=n+1;m<size;m++){
      if (numbers_r[m]<lowest){
        lowest=numbers_r[m];
        lowpos=m;
      }
    }
    temp=numbers_r[n];
    numbers_r[n]=numbers_r[lowpos];
    numbers_r[lowpos]=temp;
    }
    for (int i=0;i<size;i++)
    {
      model_s.addElement(numbers_r[i]);
    }
  }
}




