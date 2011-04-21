import java.util.Scanner;

/**
 * Winkel
 */
public class Winkel
{
	/**
	 * Grad-Wert des Winkels. Erlaubte Werte: [0, 359]
	 */
	private int grad;

	/**
	 * Minuten-Wert des Winkels. Erlaubte Werte: [0, 59]
	 */
	private int minuten;

	/**
	 * Sekunden-Wert des Winkels. Erlaubte Werte: [0, 59)
	 */
	private double sekunden;

	/**
	 * Default Konstruktor. Initialisiert den Winkel 0° 0' 0"
	 */
	public Winkel()
	{
		this(0, 0, 0);
	}

	/**
	 * Initialisiert den Winkel g° 0' 0"
	 *
	 * @param g Grad des Winkels
	 */
	public Winkel(int g)
	{
		this(g, 0, 0);
	}

	/**
	 * Initialisiert den Winkel g° m' 0"
	 *
	 * @param g Grad des Winkels
	 * @param m Minuten des Winkels
	 */
	public Winkel(int g, int m)
	{
		this(g, m, 0);
	}

	/**
	 * Initialisiert den Winkel g° m' s"
	 *
	 * @param g Grad des Winkels
	 * @param m Minuten des Winkels
	 * @param s Sekunden des Winkels
	 */
	public Winkel(int g, int m, double s)
	{
		grad = g;
		minuten = m;
		sekunden = s;
	}

	/**
	 * Initialisiert den Winkel.
	 *
	 * @param str String in der Form <g°m's">
	 */
	public Winkel(String str)
	{
		Scanner sc = new Scanner(str);
		sc.useDelimiter("[°'\"]");
		if (sc.hasNextInt())
			grad = sc.nextInt();
		if (sc.hasNextInt())
			minuten = sc.nextInt();
		if (sc.hasNextDouble())
			sekunden = sc.nextDouble();
	}

	/**
	 * Setzt die Werte für Grad, Minuten und Sekunden.
	 *
	 * @param g Grad des Winkels
	 * @param m Minuten des Winkels
	 * @param s Sekunden des Winkels
	 */
	public void setze(int g, int m, double s)
	{
		grad = g;
		minuten = m;
		sekunden = s;
	}

	/**
	 * Gibt den Winkel als Gleitkommazahl zurück.
	 *
	 * @return Winkel als Gleitkommazahl
	 */
	public double alsDouble()
	{
		//normalisiere();
		return (double)grad + (double)minuten / 60 + (double)sekunden / (60*60);
	}

	/**
	 * Gibt den Winkel im Bogenmaß zurück.
	 *
	 * @return Wert des Winkels im Bogenmaß
	 */
	public double imBogenmass()
	{
		return alsDouble() * Math.PI / 180;
	}

	/**
	 * Addiert zwei Winkel und gibt die Summe zurück
	 *
	 * @param a Zweiter Winkel
	 * @return (this) + a
	 */
	public Winkel plus(Winkel a)
	{
		return new Winkel(grad + a.grad, minuten + a.minuten, sekunden + a.sekunden);
	}

	/**
	 * Gibt den Wert des Winkels als String zurück.
	 *
	 * @return String in der Form <g°m's">
	 */
	public String toString()
	{
		return grad + "°" + minuten + "'" + sekunden + "\"";
	}

	/**
	 * Vergleicht zwei Winkel.
	 *
	 * @return true, wenn beide Winkel gleich sind
	 */
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Winkel))
			return false;

		Winkel w = (Winkel)obj;

		if (grad % 360 != w.grad % 360)
			return false;
		if (minuten % 60 != w.minuten % 60)
			return false;
		if (sekunden % 60 != w.sekunden % 60)
			return false;
		return true;
	}

	/**
	 * Klont den Winkel
	 */
	public Winkel clone()
	{
		return new Winkel(grad, minuten, sekunden);
	}

	/**
	 * Normalisiert den Winkel
	 */
	void normalisiere()
	{
		grad %= 360;
		minuten %= 60;
		sekunden %= 60;
	}
}
