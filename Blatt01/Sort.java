class Sort
{
	public static void sort(int a[])
	{
		if (a.length <= 1)
			return;

		// Middle of the array, roundet up
		int midUp = (a.length + 1) / 2;

		// Middle roundet down
		int midDown = a.length / 2;

		// a1 is at most 1 larger than a2
		int a1[] = new int[midUp];
		int a2[] = new int[midDown];

		// Fill the subarrays
		for (int i=0; i < midUp; ++i)
			a1[i] = a[i];

		for (int i=0; i < midDown; ++i)
			a2[i] = a[i + midUp];

		// And sort them
		sort(a1);
		sort(a2);

		// Current index into the main array
		int i = 0;
		// and the subarrays
		int i1 = 0;
		int i2 = 0;

		// Refill the main array
		while (i1 < a1.length && i2 < a2.length) {
			if (a1[i1] < a2[i2]) {
				a[i++] = a1[i1];
				i1++;
			}
			else {
				a[i++] = a2[i2];
				i2++;
			}
		}

		// Fill the rest
		if (i1 < a1.length) {
			for (; i1 < a1.length; ++i1)
				a[i++] = a1[i1];
		}
		else {
			for (; i2 < a2.length; ++i2)
				a[i++] = a2[i2];
		}

	}

	public static void print(int a[])
	{
		for (int d : a)
			System.out.printf("%d ", d);
		System.out.printf("\n");
	}

	public static void main(String args[])
	{
		int a[] = new int[args.length];

		for (int i=0; i < args.length; ++i) {
			a[i] = Integer.parseInt(args[i]);
		}

		System.out.println("Unsortiert:");
		print(a);

		sort(a);

		System.out.println("Sortiert:");
		print(a);
	}
}
