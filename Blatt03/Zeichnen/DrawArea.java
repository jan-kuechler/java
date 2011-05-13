import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DrawArea extends JPanel implements MouseListener, MouseMotionListener
{
	private LinkedList<Form> forms;
	Form curForm = null;

	int x, y;

	enum DrawType
	{
		Line, Rect, Oval
	}
	private DrawType type;

	public void SetDrawType(DrawType dt)
	{
		type = dt;
		x = -1;
		y = -1;
	}

	public void Clear()
	{
		forms.clear();
		curForm = null;
		x = -1;
		y = -1;

		repaint();
	}

	public DrawArea()
	{
		forms = new LinkedList<Form>();

		x = -1;
		y = -1;

		type = DrawType.Line;

		setPreferredSize(new Dimension(640, 480));
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override public void paintComponent(Graphics gfx)
	{
		super.paintComponent(gfx);

		for (Form f : forms)
			f.Draw(gfx);
		if (curForm != null)
			curForm.Draw(gfx);
	}

	@Override public void mouseClicked(MouseEvent e)
	{
		if (x == -1 && y == -1) {
			x = e.getX();
			y = e.getY();
		}
		else {
			switch (type)
			{
			case Line:
				forms.add(new Line(x, y, e.getX(), e.getY()));
				break;
			case Rect:
				forms.add(new Rect(x, y, e.getX(), e.getY()));
				break;
			case Oval:
				forms.add(new Oval(x, y, e.getX(), e.getY()));
				break;
			}
			x = -1;
			y = -1;
			repaint();
		}

	}

	@Override public void mouseDragged(MouseEvent e)
	{
		if (curForm == null) {
			x = e.getX();
			y = e.getY();
			switch (type)
			{
			case Line:
				curForm = new Line(x, y, e.getX(), e.getY());
				break;
			case Rect:
				curForm = new Rect(x, y, e.getX(), e.getY());
				break;
			case Oval:
				curForm = new Oval(x, y, e.getX(), e.getY());
				break;
			}
		}
		else {
			curForm.SetBCoord(e.getX(), e.getY());
		}
		repaint();
	}

	@Override public void mouseReleased(MouseEvent e)
	{
		if (curForm != null) {
			forms.add(curForm);
			curForm = null;
		}
	}

	@Override public void mousePressed(MouseEvent e)  {}
	@Override public void mouseEntered(MouseEvent e)  {}
	@Override public void mouseExited(MouseEvent e)   {}
	@Override public void mouseMoved(MouseEvent e)    {}
}
