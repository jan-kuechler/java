public class CD extends Silberscheibe
{
	private boolean beschreibbar;

	public CD()
	{
		this("", false, 0);
	}

	public CD(String t)
	{
		this(t, false, 0);
	}

	public CD(String t, boolean b)
	{
		this(t, b, 0);
	}

	public CD(String t, boolean b, int g)
	{
		super(t, g);
		beschreibbar = b;
	}

	public String toString()
	{
		return "CD" + (beschreibbar ? "-RW" : "") + ": \"" + getTitel() + "\" mit der Größe " + getGroesse();
	}
}
