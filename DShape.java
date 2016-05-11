import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class DShape 
{
	private DRect rectangle;
	private Rectangle test;
	
	DShape()
	{
		
	}
	public DRect getDRectangle()
	{
		return rectangle;
	}
	
	
	
	
	public void draw(Graphics g) {
		
		
	}
	

	public Point[] getKnobs(DShapeModel dshapemodel) 
	{
		Point p  = new Point(dshapemodel.getX()-3, dshapemodel.getY()-3); // Top Left Point
		Point p1 = new Point(dshapemodel.getWidth()+dshapemodel.getX()-3, dshapemodel.getY()-3); // Top Right Point
		Point p2 = new Point(dshapemodel.getX()-3,dshapemodel.getHeight() +dshapemodel.getY()-3); // Bottom Left
		Point p3 = new Point(dshapemodel.getX()+dshapemodel.getWidth()-3,
				dshapemodel.getHeight() + dshapemodel.getY()-3); // Bottom Right
		
		Point []listofpoints = {p,p1,p2,p3};	
		return listofpoints;
		
	}
	
}
