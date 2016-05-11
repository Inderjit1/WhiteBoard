import java.awt.Graphics;
import java.awt.Point;


public class DOval extends DShape
{
	private Point p;
	private DShapeModel dshapemodel;
	
	DOval()
	{
		p = new Point(0,0);

	}
	
	DOval(DOvalModel dovalmodel)
	{
		p = new Point(dovalmodel.getX(), dovalmodel.getY());
		dshapemodel = new DShapeModel(dovalmodel.getX(), dovalmodel.getY(), 
				dovalmodel.getHeight(), dovalmodel.getWidth(), dovalmodel.getColor());
	
	}
	
	public DOval(DShapeModel d) 
	{
		p = new Point(d.getX(), d.getY());
		dshapemodel = new DShapeModel(d.getX(), d.getY(), d.getHeight(), d.getWidth(), d.getColor());
	}

	public Point getPoint()
	{
		return p;
	}
	
	public DShapeModel dshapemodel()
	{
		return dshapemodel;
	}
	
	public void draw(Graphics g)
	{
		g.drawOval((int)p.getX(), (int)p.getY(), dshapemodel.getHeight(), dshapemodel.getWidth());
		g.fillOval((int)p.getX(), (int)p.getY(), dshapemodel.getHeight(), dshapemodel.getWidth());
		g.setColor(dshapemodel.getColor());
		
	}

}
