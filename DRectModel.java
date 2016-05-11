import java.awt.Color;
import java.awt.Rectangle;


public class DRectModel extends DShapeModel
{
	
	DRectModel()
	{
		this.setX(0);
		this.setY(0);
		this.setHeight(0);
		this.setWidth(0);
		this.setColor(Color.GRAY);
		
	}
	DRectModel(int a,int b, int h, int w, Color c)
	{
		this.setX(a);
		this.setY(b);
		this.setHeight(h);
		this.setWidth(w);
		this.setColor(c);
	}
	
	
	/*private int xrect;
	private int yrect;
	private int heightrect;
	private int widthrect;
	private Color colorrect;
	
	public int getXRect() {return xrect;}
	public int getYRect() {return yrect;}
	public int getHeightRect() {return heightrect;}
	public int getWidthRect() {return widthrect;}
	public Color getColorRect() {return colorrect;}
	
	public void setXRect(int a) {this.xrect = a;}
	public void setYRect(int b) {this.yrect = b;}
	public void setHeightRect(int c) {this.heightrect = c;}
	public void setWidthRect(int d) {this.widthrect = d;}
	public void setColorRect(Color e) {this.colorrect = e;}
	
	
	
	DRectModel()
	{
		// Default everything to zero and color to grey
		xrect = 0;
		yrect = 0;
		heightrect = 0;
		widthrect = 0;
		colorrect = Color.GRAY;
		
	}
	
	DRectModel(int a,int b, int h, int w, Color c)
	{
		this.xrect = a;
		this.yrect= b;
		this.heightrect= h;
		this.widthrect = w;
		this.colorrect = c;
	}*/
	
	

}
