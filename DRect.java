import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DRect extends DShape
{
	private Rectangle r; // A rectangle object
	private DShapeModel dshapemodel; // Reference to a DShape model
	
	DRect() // Default Constructor sets the rectangle to 0
	{
		r = new Rectangle(0,0,0,0);
		
	}
	
	DRect(DShapeModel d)
	{
		r = new Rectangle(d.getX(), d.getY(),d.getHeight(),d.getWidth());
		dshapemodel = new DShapeModel(d.getX(), d.getY(),d.getHeight(),d.getWidth(), d.getColor());
		

	}
	
	DRect(DRectModel drectmodel)
	{
		r = new Rectangle(drectmodel.getX(), drectmodel.getY(),drectmodel.getHeight(),drectmodel.getWidth());

		dshapemodel = new DShapeModel(drectmodel.getX(), drectmodel.getY(), 
				(int)drectmodel.getHeight(),drectmodel.getWidth(), drectmodel.getColor());
		
		// Based on the drectmodel outline, create a rectangle for it
		/*r = new Rectangle((int) drectmodel.getXRect(), (int) drectmodel.getYRect(),
				(int) drectmodel.getHeightRect(),(int) drectmodel.getWidthRect());
		
		// Also create a dshapemodel so that information about the model can be provided later on
		dshapemodel = new DShapeModel((int) drectmodel.getXRect(), (int)drectmodel.getYRect(), 
				(int)drectmodel.getHeightRect(),(int)drectmodel.getWidthRect(), drectmodel.getColor());*/
		
	}
	
	
	
	public Rectangle getRectangle() // Gets the rectangle object
	{
		return r;
	}
	
	public DShapeModel getDShapeModel() // Gets the dshapemodel here
	{
		return dshapemodel;
	}
	
	public void draw(Graphics g)
	{
		g.drawRect((int) r.getX(), (int)r.getY(), (int)r.getHeight(), (int)r.getWidth());
		g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getHeight(), (int)r.getWidth());
		g.setColor(dshapemodel.getColor());
		
	}
	


	

}
