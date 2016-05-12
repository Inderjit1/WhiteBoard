import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;





import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class WhiteBoard extends JFrame
{
	
	public void create()
	{
		JFrame whiteboard = new JFrame("WhiteBoard");
		whiteboard.setDefaultCloseOperation(EXIT_ON_CLOSE);
		whiteboard.setLayout(new BorderLayout());


		final Canvas c = new Canvas(200,200); // JPanel for Canvas


		
		final JPanel buttons = new JPanel(); // JPanel for buttons
		buttons.setPreferredSize(new Dimension(300,300));
		buttons.setBackground(Color.GRAY);
		JLabel add = new JLabel("Add");
		
		
		// Creates a default table model so that we can add columns and rows
		DefaultTableModel d = new DefaultTableModel();
		d.addColumn("X");
		d.addColumn("Y");
		d.addColumn("Height");
		d.addColumn("Width");
		
		
	
		// Create a JTable with the defaulttablemodel
		JTable table = new JTable(d);
		
		// Have to add it to a JScrollPane or else it won't appear
		JScrollPane t = new JScrollPane(table);
	
	
	
		
		
		JButton AddRect = new JButton("Rect");
		AddRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i)
			{
				
				/*Random rand = new Random();
				
				int x = rand.nextInt(200);
				int y = rand.nextInt(200);
				int height = rand.nextInt(200);
				int width = rand.nextInt(200);
				
				
				int firstparam = rand.nextInt(256);
				int secondparam = rand.nextInt(256);
				int thirdparam = rand.nextInt(256);
				
				Color different = new Color(firstparam,secondparam,thirdparam);
				
				//DRectModel drectmodel= new DRectModel(x,y,height, width,different);*/
				
				DRectModel drectmodel= new DRectModel(10,10,20, 20, Color.red);
				c.addShape(drectmodel);
				
				
			}
			
		});
		
		JButton AddOval = new JButton("Oval");
		AddOval.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent i)
			{
				System.out.println("IN OVAL");
		
				DOvalModel dovalmodel = new DOvalModel(40, 40,50,50, Color.BLUE);
				
				c.addShape(dovalmodel);
			}
			
		});
		
		JButton AddLine = new JButton("Line");
		AddLine.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent i)
			{
				
			}
		});
		
		JButton AddText = new JButton("Text");
		AddText.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent i)
			{
				
			}
		});
		
		final JColorChooser color = new JColorChooser();
		JButton AddSetColor = new JButton("Set Color");
		AddSetColor.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent i)
			{
				c.choiceofcolor();
							
			}
	
		});
		
		JButton AddMovetoFront= new JButton("Move to Front");
		AddMovetoFront.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("HRE");
				
			}
		});
		
		JButton AddMovetoBack = new JButton("Move to Back");
		AddMovetoBack.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent i)
			{
				
			}
		});
		
	
		
		JButton AddRemoveShape= new JButton("Remove Shape");
		AddRemoveShape.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent i)
			{
				c.removeShape();
				
			}
		});
		
		
		
		
		
		buttons.add(add);
		buttons.add(AddRect);
		buttons.add(AddOval);
		buttons.add(AddLine);
		buttons.add(AddText);
		buttons.add(AddSetColor);
		buttons.add(AddMovetoFront);
		buttons.add(AddMovetoBack);
		buttons.add(AddRemoveShape);
		buttons.add(AddSetColor);
		
		
	
		
		
		whiteboard.add(c, BorderLayout.CENTER);
		whiteboard.add(buttons,BorderLayout.WEST);
		whiteboard.add(t, BorderLayout.SOUTH);
	
		
		whiteboard.pack();
		whiteboard.setVisible(true);
	}
	
	
	
	
	
	public static void main(String []args)
	{
		WhiteBoard test = new WhiteBoard();
		test.create();
	}

}
