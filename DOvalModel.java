import java.awt.Color;


public class DOvalModel extends DShapeModel
{
	DOvalModel()
	{
		this.setX(0);
		this.setY(0);
		this.setHeight(0);
		this.setWidth(0);
		this.setColor(Color.GRAY);
	}
	
	DOvalModel(int a, int b, int c, int d, Color e)
	{
		this.setX(a);
		this.setY(b);
		this.setHeight(c);
		this.setWidth(d);
		this.setColor(e);
	}
	/*private int xoval;
	private int yoval;
	private int heightoval;
	private int widthoval;
	private Color ovalcolor;

	public int getXOval() {return xoval;}
	public int getYOval() {return yoval;}
	public int getHeightOval() {return heightoval;}
	public int getWidthOval() {return widthoval;}
	public Color getOvalColor() {return ovalcolor;}
	
	DOvalModel()
	{
		this.xoval = 0;
		this.yoval = 0;
		this.heightoval = 0;
		this.widthoval = 0;
		this.ovalcolor = Color.GRAY;
	}
	
	DOvalModel(int a, int b, int c, int d, Color e)
	{
		this.xoval = a;
		this.yoval = b;
		this.heightoval = c;
		this.widthoval = d;
		this.ovalcolor = e;
	}*/
	
}
