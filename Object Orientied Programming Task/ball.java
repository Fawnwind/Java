public class ball
{
 protected int x_pos = 0;
 protected int y_pos = 0;
 protected int x_speed = 0;
 protected int y_speed = 0;
 protected int size = 0;
 protected int color = 0;
 	public void start(int xpos,int ypos,int s,int c)
 	{
 		x_pos = xpos;
 		y_pos = ypos;
		size = s;
		color = c;
 	}
 	public void speedchangex(int x)
 	{
 		x_speed = x;
 	}
 	public void speedchangey(int x)
 	{
 		y_speed = x;
 	}
 	public void speed(int xs,int ys)
 	{
 		x_speed = xs;
 		y_speed = ys;
 	}
 	public void move()
 	{
 		x_pos = x_pos + x_speed;
 		y_pos = y_pos + y_speed;
 	}
 	public int getxpos()
 	{
    return x_pos;
 	}
 	public int getypos()
 	{
 		return y_pos;
 	}
 	public int getcolor()
 	{
 		return color;
 	}
 	public int getsizes()
 	{
 		return size;
 	}
 	public int getxspeed()
 	{
 		return x_speed;
 	}
 	public int getyspeed()
 	{
 		return y_speed;
 	}
}