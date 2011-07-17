import java.awt.*;

class Rect extends Form
{
	public Rect()
	{
	}

	public Rect(int xa, int ya, int xb, int yb)
	{
		super(xa, ya, xb, yb);
	}

	@Override public void Draw(Graphics gfx)
	{
		int xa = x1 < x2 ? x1 : x2;
		int xb = x1 > x2 ? x1 : x2;
		int ya = y1 < y2 ? y1 : y2;
		int yb = y1 > y2 ? y1 : y2;

		gfx.drawRect(xa, ya, xb - xa, yb - ya);
	}
}
