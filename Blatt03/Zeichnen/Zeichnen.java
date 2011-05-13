import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class Zeichnen extends JFrame
{
	DrawArea draw;

	public Zeichnen()
	{
		super("Zeichnen");


		// Drawing area
		draw = new DrawArea();

		// Selection panel
		JPanel pnSelect = new JPanel();

		ButtonGroup selection = new ButtonGroup();
		JRadioButton rbLine = new JRadioButton("Strecke", true);
		rbLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.SetDrawType(GetSelectedDrawType(e.getActionCommand()));
			};
		});
		JRadioButton rbRect  = new JRadioButton("Rechteck");
		rbRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.SetDrawType(GetSelectedDrawType(e.getActionCommand()));
			};
		});
		JRadioButton rbOval = new JRadioButton("Ellipse");
		rbOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.SetDrawType(GetSelectedDrawType(e.getActionCommand()));
			};
		});

		selection.add(rbLine);
		selection.add(rbRect);
		selection.add(rbOval);
		pnSelect.add(rbLine);
		pnSelect.add(rbRect);
		pnSelect.add(rbOval);

		JMenuBar mbar = new JMenuBar();
		JMenu menu = new JMenu("Zeichnung");

		JMenuItem miClear = new JMenuItem("Löschen");
		miClear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw.Clear();
			};
		});
		menu.add(miClear);

		JMenuItem miExit = new JMenuItem("Beenden");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			};
		});
		menu.add(miExit);
		mbar.add(menu);
		setJMenuBar(mbar);


		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(pnSelect, BorderLayout.NORTH);
		add(draw, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private DrawArea.DrawType GetSelectedDrawType(String cmd)
	{
		if (cmd.equals("Strecke"))
			return DrawArea.DrawType.Line;
		if (cmd.equals("Rechteck"))
			return DrawArea.DrawType.Rect;
		if (cmd.equals("Ellipse"))
			return DrawArea.DrawType.Oval;
		throw new RuntimeException("Unknown selection");
	}



	public static void main(String args[])
	{
		new Zeichnen();
	}
}