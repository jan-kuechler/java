public class Festplatte extends Datentraeger
{
	private int nPart;

	public Festplatte()
	{
		this(0, 0);
	}

	public Festplatte(int part)
	{
		this(part, 0);
	}

	public Festplatte(int part, int gr)
	{
		super(gr);
		nPart = part;
	}

	public int getAnzahlPartitionen()
	{
		return nPart;
	}

	public String toString()
	{
		return "Festplatte der Größe " + getGroesse() + " mit " + nPart + " Partitionen";
	}
}
