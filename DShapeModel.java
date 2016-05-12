import java.awt.Color;


public class DShapeModel {
	private int x;
	private int y;
	private int height;
	private int width;
	private Color color;
	
	DShapeModel()
	{
		x = 0;
		y = 0;
		height = 0;
		width = 0;
		color = Color.gray;
	}
	
	DShapeModel(int a, int b, int c, int d, Color e) 
	{
		this.x = a;
		this.y = b;
		this.height = c;
		this.width = d;
		this.color = e;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	
	public void moveBy(int dx, int dy)
	{
		x = x + dx;
		y = y + dy;
	}

	public void remove() {
		this.x = 0;
		this.y = 0;
		this.height = 0;
		this.width = 0;
		this.color = Color.white;
	
		
	}
}
