// Code that creates a DrawPanel and displays an image
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

public class visual extends JFrame implements ActionListener,Runnable
{

  String[] set = {"Merge Sort","Quick Sort","Bubble","Insert Selection","Selection Exchange","Double Bubble"};

  MyDrawPanel draw1=new MyDrawPanel();

  JPanel main = new JPanel();
  JPanel south = new JPanel();

  JButton gen = new JButton ("Gen");
  JButton sort = new JButton ("Sort");

  JComboBox select = new JComboBox(set);

  int size = 391;
  int range = 330;
  int[] numbers = new int[size];
  int[] helper = new int[size];
  int counter = 0;
  int sleep = 6;
  int swaps = 0;
  int flag = 0;
  int temp = 0;
  int nextsize = 0;


  public static void main(String[ ] args)
  {

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (UnsupportedLookAndFeelException e) {
    }
    catch (ClassNotFoundException e) {
    }
    catch (InstantiationException e) {
    }
    catch (IllegalAccessException e) {
    }

    (new Thread(new visual())).start();

  }

  public visual (){

    gen.addActionListener(this);
    sort.addActionListener(this);

    sort.setEnabled(false);

    south.add(gen);
    south.add(sort);
    south.add(select);

    main.setLayout(new BorderLayout());
    south.setLayout(new GridLayout(1,3,0,2));

    main.add(draw1,BorderLayout.CENTER);
    main.add(south,BorderLayout.SOUTH);

    this.add(main);
    this.setSize(799,400);
    this.setVisible(true);

    for (int i=0;i<size;i++)
    {
      Random r = new Random();
      numbers[i] = r.nextInt(range);
    }

  }

  public void run()
  {
    do
    {
      try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}

      if (counter==1)
      {
        if(select.getSelectedIndex()==0)
        {
          mergesort(0,size-1);

          mergesort(0,size-1);
          for (int i=0;i<size;i++)
          {
            helper[i] =6000;
          }
        }
        else if(select.getSelectedIndex()==1)
        {
          qsort(numbers,0,numbers.length-1);
        }
        else if(select.getSelectedIndex()==2)
        {
          Bubble();
        }
      }
      counter = 0;

      repaint();
    }while(size!=600);

  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource()==gen)
    {
      for (int i=0;i<size;i++)
      {
        Random r = new Random();
        numbers[i] = r.nextInt(range);
      }
      sort.setEnabled(true);
    }
    else if (e.getSource()==sort)
    {
      counter = 1;
    }

  }

  class MyDrawPanel extends JPanel
  {

    public void paintComponent(Graphics g) {

      Graphics2D g2 = (Graphics2D)g;

      for (int i=0;i<size;i++)
      {
        g2.setColor(Color.BLACK);
        if (numbers[i]==helper[i])
          g2.setColor(Color.GREEN);
        g2.drawLine(i*2+1,335-numbers[i],i*2+1,335);

      }

    }
  }

  public void mergesort(int low, int high) {
    try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
    repaint();
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergesort(low, middle);
      mergesort(middle + 1, high);
      try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();
      merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high) {
    try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();

    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }
    try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();
    while (i <= middle) {
      numbers[k] = helper[i];
      k++;
      i++;
    }
  }

  public  void qsort(int a[], int start, int finish) {
    int lo = start;
    int hi = finish+1;
    int flag = 0;

    try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
    repaint();

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
          helper[lo] = a[lo];
          try
          {
            Thread.sleep(sleep);
          }
          catch (InterruptedException ex){}
          repaint();
          a[lo]=a[hi];

          swaps = swaps +1;
        }

      }
      flag=0;
      while (lo<hi && flag==0) {
        lo++;
        if (a[lo]>pivot){
          flag=1;
          helper[lo] = a[lo];
          try
          {
            Thread.sleep(sleep);
          }
          catch (InterruptedException ex){}
          repaint();
          a[hi]=a[lo];
          swaps = swaps +1;
        }
      }
    }
    if (lo==hi)
    {
      a[hi]=pivot;
      helper[hi] = a[hi];
      try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();
      swaps = swaps +1;
    }
    qsort(a, start, lo-1);
    qsort(a, hi+1, finish);
  }

  public void Bubble(){

      for (int m=size-1;m>=1;m--){

      try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();
      flag=0;
      for (int n=0;n<m;n++){

        if (numbers[n+1]<numbers[n]){
          temp=numbers[n+1];


          numbers[n+1]=numbers[n];
          numbers[n]=temp;

          repaint();
          nextsize++;
          if (nextsize ==1000000000);
          {
            try
          {
            Thread.sleep(0);
            nextsize = 0;
          }
          catch (InterruptedException ex){}
          }


          flag=1;
          swaps = swaps+1;


        }
      }
      if (flag==0){
        m=0;
      }
    }
  }
}



