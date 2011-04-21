public abstract class Silberscheibe extends Datentraeger
{
	private String titel;

	public Silberscheibe()
	{
		this("", 0);
	}

	public Silberscheibe(String t)
	{
		this(t, 0);
	}

	public Silberscheibe(String t, int g)
	{
		super(g);
		titel = t;
	}

	public String getTitel()
	{
		return titel;
	}

	public String toString()
	{
		return "Silberscheibe der Größe " + getGroesse() + " mit dem Titel \"" + titel + "\"";
	}
}
