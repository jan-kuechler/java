import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.io.*;

public class Zeichnen extends JFrame
{
	Zeichnen self;
	DrawArea draw;

	public Zeichnen()
	{
		super("Zeichnen");

		self = this;

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

		JMenuItem miOpen = new JMenuItem("Laden...");
		miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		miOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int res = fc.showOpenDialog(self);

				if (res == JFileChooser.APPROVE_OPTION) {
					loadFromFile(fc.getSelectedFile());
				}
			}
		});
		menu.add(miOpen);

		JMenuItem miSave = new JMenuItem("Speichern...");
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int res = fc.showSaveDialog(self);

				if (res == JFileChooser.APPROVE_OPTION) {
					saveToFile(fc.getSelectedFile());
				}
			}
		});
		menu.add(miSave);

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
				quit();
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

	private void quit()
	{
		System.exit(0);
	}

	private void saveToFile(File file)
	{
		final String NL = System.getProperty("line.separator");

		LinkedList<Form> forms = draw.getForms();

		BufferedWriter bw = null;
		try {

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			bw.write("Zeichnen"+NL);
			for (Form f: forms)
				bw.write(f + NL);

			bw.close();
		}
		catch (IOException e) {

		}
	}

	private void loadFromFile(File file)
	{
		BufferedReader br = null;
		LinkedList<Form> forms = null;

		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line = br.readLine();
			if (line == null || !line.equals("Zeichnen")) {
				JOptionPane.showMessageDialog(null, "Unbekanntes Dateiformat: " + (line == null ? "<null>" : "'" + line + "'"), "Fehler", JOptionPane.ERROR_MESSAGE);
				return;
			}

			forms = new LinkedList<Form>();
			line = br.readLine();
			while (line != null) {
				forms.add(Form.createFromString(line));
				line = br.readLine();
			}

			br.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "Fehler", JOptionPane.ERROR_MESSAGE);
			return;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Fehler", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (forms != null)
			draw.setForms(forms);
	}

	public static void main(String args[])
	{
		new Zeichnen();
	}
}