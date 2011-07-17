import java.awt.*;

class Line extends Form
{
	public Line()
	{
	}

	public Line(int xa, int ya, int xb, int yb)
	{
		super(xa, ya, xb, yb);
	}

	@Override public void Draw(Graphics gfx)
	{
		gfx.drawLine(x1, y1, x2, y2);
	}
}
