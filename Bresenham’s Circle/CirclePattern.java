import javax.swing.JFrame;
import java.awt.Graphics;

public class CirclePattern extends JFrame{
	
	//constructor
	public CirclePattern(){
		setTitle("pattern1");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	
	public void paint(Graphics g){
		super.paint(g);
		
		int xc=800; int yc = 400;
		int radius = 160;
		
		drawCircleBresenhams(g, xc, yc, radius);
		drawCircleBresenhams(g, xc, yc -( radius/2),  radius/2);
		yc = yc -( radius/2);
		drawCircleBresenhams(g, xc -(radius/4), yc,  radius/4);
		xc = xc -(radius/4);
		drawCircleBresenhams(g, xc, yc+(radius/8),  radius/8);
		yc = yc+(radius/8);
		drawCircleBresenhams(g, xc+(radius/16), yc, radius/16);
		
		
	}
	
	public void drawCircleBresenhams(Graphics g,int xc,int yc,int r)
    {
		int x =0;
		int y = r;
		int d = 3-2*r;
		
		plotCirclePoints(g,xc,yc,x,y);
		
		while(x<=y){
			x++;
			
			if(d < 0){
				d += 4*x + 6;
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
		g.drawLine(xc+x, yc+y, xc+x, yc+y); //octant 1
		g.drawLine(xc-x, yc+y, xc-x, yc+y); //octant 2
        g.drawLine(xc+x, yc-y, xc+x, yc-y); //octant 3
		g.drawLine(xc-x, yc-y, xc-x, yc-y); //octant 4
		g.drawLine(xc+y, yc+x, xc+y, yc+x); //octant 5
		g.drawLine(xc-y, yc+x, xc-y, yc+x); //octant 6
		g.drawLine(xc+y, yc-x, xc+y, yc-x); //octant 7
		g.drawLine(xc-y, yc-x, xc-y, yc-x); //octant 8
	}
	public static void main (String args[]){
		new CirclePattern().setVisible(true);
	}
	
 	
}