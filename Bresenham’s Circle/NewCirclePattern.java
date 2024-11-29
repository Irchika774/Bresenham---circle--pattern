import javax.swing.JFrame;//for creating windows frame
import java.awt.Graphics;//for drawing shapes and graphics

public class NewCirclePattern extends JFrame{
	//constructor
	public NewCirclePattern(){
		setTitle("Practice 2018");
		setSize(400,400);//setting the size of windows
		setLocationRelativeTo(null);//centering windows on the location
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	
	public void paint(Graphics g){
		super.paint(g); //calling the parent class
		
		//center of circle
		int xc=800; int yc = 400; //center cordinates
		int radius = 30;//initialize the radius of the circle
		
		//draw 8 circles
		for(int i=0; i<4; i++)
		{
			
			drawCircleBresenhams(g,xc+30*i,yc,radius*(i+1));
			drawCircleBresenhams(g,(xc-60)-30*i,yc,radius*(i+1));
		}
			
	}
	//method to draw circle using Bresenhams Algorithm
	public void drawCircleBresenhams(Graphics g,int xc,int yc,int r)
	{
		//initialize cordinates
		int x = 0;
		int y = r;
		int d = 3-2*r;
		
		plotCirclePoints(g,xc,yc,x,y);
		
		while (x <= y){
			x++;
			
			if(d<0){
				d +=4*x + 6;
			}
			
			else{
				y--;
				d += 4*(x-y)+10;
			}
			plotCirclePoints(g,xc,yc,x,y);
		}
	}
	
	private void plotCirclePoints(Graphics g,int xc,int yc,int x, int y)
	{
		g.drawLine(xc+x, yc+y, xc+x, yc+y);
		g.drawLine(xc-x, yc+y, xc-x, yc+y);
		g.drawLine(xc+x, yc-y, xc+x, yc-y);
		g.drawLine(xc-x, yc-y, xc-x, yc-y);
		g.drawLine(xc+y, yc+x, xc+y, yc+x);
		g.drawLine(xc-y, yc+x, xc-y, yc+x);
		g.drawLine(xc+y, yc-x, xc+y, yc-x);
		g.drawLine(xc-y, yc-x, xc-y, yc-x);
		
	}
	
	//Main Method
	public static void  main(String args[]){
		new NewCirclePattern().setVisible(true);
	}
}   
