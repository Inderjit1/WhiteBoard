import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Canvas extends JPanel
{
	private static ArrayList<DShapeModel> modelofshapes;
	private static ArrayList<DShape>  shape;
	private DShapeModel lastshape;
	private boolean selected = false;
	private int position = 0;
	private Point[] knobs;
	

	private boolean print;
	private boolean dirty;
	private boolean smartRepaint;
	private boolean oldRepaint;
	
	private int lastX;
	private int lastY;
	
	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	
	Canvas()
	{
		this(0,0);
	}
	
	Canvas(int a, int b)
	{
		setPreferredSize(new Dimension(a,b));
		setBackground(Color.white);
		modelofshapes = new ArrayList<DShapeModel>();
		shape = new ArrayList<DShape>();
		smartRepaint = false;
		oldRepaint = true;
	
		
		clear();
		print = false;
	
		
		addMouseMotionListener(new MouseMotionAdapter () {
			public void mouseDragged(MouseEvent e)
			{
				if(print)
					 System.out.println("drag:" + e.getX() + " " + e.getY());
				if(lastshape != null)
				{
					int dx = e.getX() - lastX;
					int dy = e.getY() - lastY;
					lastX = e.getX();
					lastY = e.getY();
					doMove(lastshape, dx, dy);
				}	
			}
			
		});
		
	
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				if(print)
					System.out.println("press" + e.getX() + " " + e.getY());
				DShapeModel dshapemodel = findLocation(e.getX(), e.getY());
				if(dshapemodel == null)
				{
					System.out.println("NULL");
					dshapemodel = add(e.getX(), e.getY());
				}
				else if(selected == true)
				{
					//shape.get(position).getKnobs();
					knobs = shape.get(position).getKnobs(dshapemodel);
					//drawKnobs(knobs);
					//shape.get(position).getDRectangle().getRectangle().getX();
					lastshape = dshapemodel;
					lastX = e.getX();
					lastY = e.getY();
				}
			}
		});
	}
	
	/*@SuppressWarnings("null")
	public void drawKnobs(Point[] k)
	{
		Graphics g = null;
		if(selected) //If selected
		{
			System.out.println("HERE INS DRAE");
			for(int i = 0; i < k.length; i++)
			{
				g.drawRect((int)k[i].getX(), (int)k[i].getY(),3,3);
			}
		}
	}*/
	
	public DShapeModel findLocation(int x, int y)
	{
		for(int i = modelofshapes.size()-1; i >=0; i--)
		{
			DShapeModel dshapemodel = modelofshapes.get(i);
			int centerX = dshapemodel.getX();
			int centerY = dshapemodel.getY();
			
			int xySquared = (x - centerX)*(x - centerX) +(y - centerY)*(y - centerY);
			int radiusSquared = dshapemodel.getWidth()*dshapemodel.getHeight();
		    
			if (xySquared <= radiusSquared) 
	        {
					position = i;
	            	selected = true;
	            	System.out.println("TRUE");
	            	//System.out.println("CHekcing" + shape.get(position).getDRectangle().getRectangle().getX());
	            	return dshapemodel;
		    }
		 
		
			
			/*if(dshapemodel instanceof DRectModel)
			{
				selected = false;
				
				int xmodel = (int) ((DRect)shape.get(i)).getRectangle().getX();
				int ymodel = (int) ((DRect)shape.get(i)).getRectangle().getY();
				
				int max = (int) ((DRect)shape.get(i)).getRectangle().getWidth() + xmodel;
				if(x >= xmodel && x <= max && y >= ymodel && y <= max)
				{
					System.out.println("TRUE");
					selected = true;
					return dshapemodel;
				}
				
			}
			
			else if(dshapemodel instanceof DOvalModel)
			{
				selected = false;
				int centerX = (int) ((DOval)shape.get(i)).getPoint().getX();
	            int centerY = (int) ((DOval)shape.get(i)).getPoint().getY();
	            // figure x-squared + y-squared, see if it's
	            // less than radius squared.
	            // trick: don't need to take square root
	            int xySquared = (x - centerX)*(x - centerX) +
	            (y - centerY)*(y - centerY);
	            int radiusSquared = (SIZE/2)*(SIZE/2);
	            if (xySquared >= radiusSquared) 
	            {
	            	selected = true;
	                return dshapemodel;
	            }
			}*/
			
		}
		return null;
		
	}
	
	
	
	public void doMove(DShapeModel dshapemodel, int a, int b)
	{
		
		if(!smartRepaint)
		{
			for(int i = modelofshapes.size()-1; i >=0; i--)
			{
				if(dshapemodel instanceof DRectModel && modelofshapes.get(i) instanceof DRectModel)
					
				{
					dshapemodel.moveBy(a, b);
					((DRect)shape.get(i)).getRectangle().x = (int) (((DRect)shape.get(i)).getRectangle().getX() + a);
					((DRect)shape.get(i)).getRectangle().y = (int) (((DRect)shape.get(i)).getRectangle().getY() + b);
				}
				
				else if(dshapemodel instanceof DOvalModel && modelofshapes.get(i) instanceof DOvalModel)
				{
					dshapemodel.moveBy(a, b);
					((DOval)shape.get(i)).getPoint().x = (int) (((DOval)shape.get(i)).getPoint().getX() + a);
					((DOval)shape.get(i)).getPoint().y = (int) (((DOval)shape.get(i)).getPoint().getY() + b);
				}
			}
	
			repaint();
		
			
		}
		
		
		setDirty(true);
		
	}
	
	
	public void clear() {
		modelofshapes.clear();
		shape.clear();
		dirty = false;
		repaint();
		// TODO Auto-generated method stub
		
	}


			
	
	
	
	public void addShape(DShapeModel dshapemodel)
	{

		if(dshapemodel instanceof DRectModel)
		{
			
			DRect drect = new DRect(dshapemodel);
			System.out.printf("getRectangle: %s\n" ,drect.getRectangle());
			shape.add(drect);
			modelofshapes.add(dshapemodel);

		}
		
		else if(dshapemodel instanceof DOvalModel)
		{
			DOval doval = new DOval(dshapemodel);
			
			System.out.printf("getOval: %s\n" ,doval.getPoint());
			shape.add(doval);
			modelofshapes.add(dshapemodel);
		}
		
		repaint();
		setDirty(true);
	}
	
	public DShapeModel add(int x ,int y)
	{
		DShapeModel dshapemodel = new DShapeModel();
		dshapemodel.setX(x);
		dshapemodel.setY(y);
		addShape(dshapemodel);
		return dshapemodel;
		
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int i = 0; i < shape.size(); i++)
		{
			g.setColor(modelofshapes.get(i).getColor());
			shape.get(i).draw(g);		
		}	
		if(selected) //If selected
		{
			//System.out.println("HERE INS DRAE");
			for(int i = 0; i < knobs.length; i++)
			{
				g.setColor(Color.black);
				g.drawRect((int)knobs[i].getX(), (int)knobs[i].getY(),9,9);
				g.fillRect((int)knobs[i].getX(), (int)knobs[i].getY(),9,9);
				
			}
		}
	

	}

	public void removeShape() {
		if(selected)
		{
			System.out.println("HERE");
			System.out.println(modelofshapes.get(position));
			modelofshapes.get(position).remove();
			repaint();
			
		}
		// TODO Auto-generated method stub
		
	}

	public void choiceofcolor() {
		if(selected)
		{
			final JColorChooser color = new JColorChooser();
			Color selected = color.showDialog(getParent(), "Choose", Color.white);
			System.out.println(selected);
			modelofshapes.get(position).setColor(selected);
			repaint();
	
		}
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	


	
	

}
