import java.awt.Graphics;

public abstract class Form
{
	protected int x1, y1;
	protected int x2, y2;

	public Form(int xa, int ya, int xb, int yb)
	{
		x1 = xa;
		y1 = ya;
		x2 = xb;
		y2 = yb;
	}

	public void SetBCoord(int x, int y)
	{
		x2 = x;
		y2 = y;
	}

	public abstract void Draw(Graphics gfx);
}
