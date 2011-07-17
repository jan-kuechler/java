import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public abstract class Form
{
	protected int x1, y1;
	protected int x2, y2;

	public Form()
	{
	}

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

	@Override public String toString()
	{
		return getClass().getName() + " " + x1 + " " + y1 + " " + x2 + " " + y2;
	}

	static public Form createFromString(String str) throws Exception
	{
		StringTokenizer tok = new StringTokenizer(str);

		if (tok.countTokens() != 5) {
			throw new Exception("Error: '" + str + "'");
		}

		Form f = null;
		String cls = tok.nextToken();
		if (cls.equals("Line"))
			f = new Line();
		else if (cls.equals("Rect"))
			f = new Rect();
		else if (cls.equals("Oval"))
			f = new Oval();

		f.x1 = Integer.valueOf(tok.nextToken());
		f.y1 = Integer.valueOf(tok.nextToken());
		f.x2 = Integer.valueOf(tok.nextToken());
		f.y2 = Integer.valueOf(tok.nextToken());

		return f;
	}

	public abstract void Draw(Graphics gfx);
}
