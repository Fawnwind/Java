// Code that creates a DrawPanel and displays an image
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

public class visual extends JFrame implements ActionListener,Runnable
{

  String[] set = {"Merge Sort","Quick Sort","Bubble","Double Bubble","Selection Exchange"};

  MyDrawPanel draw1=new MyDrawPanel();
  int sleep = 5;
  JPanel main = new JPanel();
  JPanel south = new JPanel();

  JButton gen = new JButton ("Gen");
  JButton sort = new JButton ("Sort");
  JButton plus = new JButton("Speed + ");
  JButton minus = new JButton("Speed - ");

  String speed = ("Medium");

  JLabel threadspeeed = new JLabel(" Speed");

  JComboBox select = new JComboBox(set);

  int size = 391;
  int range = 330;
  int[] numbers = new int[size];
  int[] helper = new int[size];
  int counter = 0;

  int swaps = 0;
  int flag = 0;
  int temp = 0;
  int nextsize = 0;

  String sorting_t = "Standbye";
  int gensort_i =0;
  int dots =0;

  String[] dots_t = {".","..","..."};

  Color sky = new Color(0,0,0);


  public static void main(String[ ] args)
  {

    try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
    catch (UnsupportedLookAndFeelException e) {}
    catch (ClassNotFoundException e) {}
    catch (InstantiationException e) {}
    catch (IllegalAccessException e) {}

    new Thread(new visual()).start();

  }

  public visual (){

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image cursorImage = toolkit.getImage("moony.png");
    Point cursorHotSpot = new Point(0,0);
    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
    this.setCursor(customCursor);

    this.setLocation(300,300);
    this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());

    gen.addActionListener(this);
    sort.addActionListener(this);
    plus.addActionListener(this);
    minus.addActionListener(this);


    draw1.setBackground(sky);
    south.setBackground(sky);
    gen.setBackground(sky);
    sort.setBackground(sky);
    south.add(gen);
    south.add(sort);
    sort.setEnabled(false);


    south.add(plus);
    south.add(minus);
    south.add(select);
    plus.setBackground(sky);
    minus.setBackground(sky);
    select.setBackground(sky);

    main.setLayout(new BorderLayout());
    south.setLayout(new GridLayout(1,5,0,4));

    main.add(draw1,BorderLayout.CENTER);
    main.add(south,BorderLayout.SOUTH);

    this.add(main);
    this.setSize(799,400);
    this.setVisible(true);


    this.setTitle("Sorting Visualizer Liam Crozier 2015");
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

      if(gensort_i ==1)
      {
        gensort();
        gensort_i=0;
      }


      if (counter==1)
      {
        for (int i=0;i<size;i++)
        {
          helper[i] =6000;
        }
        sort.setEnabled(false);
        gen.setEnabled(false);
        if(select.getSelectedIndex()==0)
        {
          mergesort(0,size-1);

          mergesort(0,size-1);

        }
        else if(select.getSelectedIndex()==1)
        {
          qsort(numbers,0,numbers.length-1);
        }
        else if(select.getSelectedIndex()==2)
        {
          Bubble();
        }
        else if(select.getSelectedIndex()==3)
        {
          DoubleBubble();
        }
        else if(select.getSelectedIndex()==4)
        {
          SelectEx();
        }
        sort.setEnabled(true);
        gen.setEnabled(true);
      }
      counter = 0;

      repaint();
    }while(size!=600);

  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource()==gen)
    {
      gensort_i=1;

    }
    else if (e.getSource()==sort)
    {
      counter = 1;
    }
    else if(e.getSource()==minus)
    {
      sleep++;
      minus.setText("Speed - ");
      plus.setText("Speed + ");
    }
    else if(e.getSource()==plus&&sleep!=1)
    {
      sleep--;
      plus.setText("Speed + ");
      minus.setText("Speed - ");
    }
    if (sleep<3)
    {
      speed = "Fast";
    }
    else if (sleep<6)
    {
      speed = "Medium";
    }
    else if (sleep<10)
    {
      speed = "Slow";
    }
    else
    {
      speed = "A Long Time";
    }
  }

  class MyDrawPanel extends JPanel
  {

    public void paintComponent(Graphics g) {
      g.setColor(sky);
      g.fillRect(0,0,9000,9000);
      Graphics2D g2 = (Graphics2D)g;


      for (int i=0;i<size;i++)
      {
        g2.setColor(Color.WHITE);
        if (numbers[i]==helper[i])
          g2.setColor(Color.GREEN);
        g2.drawLine(i*2+1,335-numbers[i],i*2+1,337);
      }
      g2.setColor(Color.RED);
      g2.drawString(set[select.getSelectedIndex()],5,15);
      g2.drawString(speed+" ("+sleep+" Mils)", 5, 30);

      if(gensort_i==1||counter==1)
        g2.drawString("Processing"+dots_t[dots], 5, 45);

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
      dots++;
      if (dots>2)
      {
        dots =0;
      }
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
      dots++;
      if (dots>2)
      {
        dots =0;
      }
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
      dots++;
      if (dots>2)
      {
        dots =0;
      }
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
    int x=0;

    for (int m=size-1;m>=1;m--){
      dots++;
      if (dots>2)
      {
        dots =0;
      }
      nextsize = 0;
      repaint();
      flag=0;
      for (int n=0;n<m;n++){
        x++;
        try{if(x>10){Thread.sleep(sleep);x=0;}}
        catch (InterruptedException ex){}
        repaint();

        if (numbers[n+1]<numbers[n]){
          temp=numbers[n+1];

          numbers[n+1]=numbers[n];
          numbers[n]=temp;

          repaint();
          nextsize++;
          flag=1;
          swaps = swaps+1;
        }
      }
      if (flag==0){
        m=0;
      }
    }
  }
  public void DoubleBubble()
  {
    boolean swapped = true;
    int i = 0;
    int j = numbers.length - 1;
    int x=0;
    while(i < j && swapped)
    {



      swapped = false;
      for(int k = i; k < j; k++)
      {
        dots++;
        if (dots>2)
        {
          dots =0;
        }
        if(numbers[k] > numbers[k + 1])
        {
          x++;
          int temp = numbers[k];
          try{if(x>10){Thread.sleep(sleep);x=0;}}
          catch (InterruptedException ex){}
          repaint();

          numbers[k] = numbers[k + 1];
          numbers[k + 1] = temp;
          swapped = true;
          swaps = swaps +1;


        }
      }
      helper[j] = numbers[j];
      j--;
      if(swapped)
      {
        swapped = false;
        for(int k = j; k > i; k--)
        {
          if(numbers[k] < numbers[k - 1])
          {
            int temp = numbers[k];
            swaps = swaps +1;
            x++;
            try{if(x>10){Thread.sleep(sleep);x=0;}}
            catch (InterruptedException ex){}
            repaint();

            numbers[k] = numbers[k - 1];
            numbers[k - 1] = temp;
            swapped = true;


          }
        }
      }
      helper[i] = numbers[i];
      i++;

    }
  }
  public  void SelectEx(){
    int lowpos = 0;
    int lowest = 0;
    int x = 0;
    for (int n=0;n<size;n++){
      lowest=numbers[n];
      for (int j=0;j<n+1;j++)
      {
        helper[j]=numbers[j];
      }

      lowpos=n;

      for (int m=n+1;m<size;m++){
        dots++;
        if (dots>2)
        {
          dots =0;
        }
        x++;
        try
        {
          if(x>30)
          {
            Thread.sleep(sleep);
            x =0;
          }
        }
        catch (InterruptedException ex){}
        repaint();
        if (numbers[m]<lowest){
          lowest=numbers[m];
          swaps = swaps +1;
          lowpos=m;
        }
      }
      temp=numbers[n];
      numbers[n]=numbers[lowpos];
      numbers[lowpos]=temp;
      swaps = swaps +1;
    }
  }
  public void gensort(){
    sort.setEnabled(false);
    for (int i=0;i<size;i++)
    {
      numbers[i]=0;
    }
    for (int i=0;i<size;i++)
    {
      dots++;
      if (dots>2)
      {
        dots =0;
      }
      Random r = new Random();
      numbers[i] = r.nextInt(range);
      try
      {
        Thread.sleep(sleep);
      }
      catch (InterruptedException ex){}
      repaint();
    }
    sort.setEnabled(true);
  }
}



