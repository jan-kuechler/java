public abstract class Datentraeger
{
	private int groesse;

	public Datentraeger()
	{
		this(0);
	}

	public Datentraeger(int g)
	{
		groesse = g;
	}

	public int getGroesse()
	{
		return groesse;
	}

	public String toString()
	{
		return "Datenträger der Größe " + groesse;
	}
}
