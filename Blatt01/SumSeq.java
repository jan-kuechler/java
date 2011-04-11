import java.util.Scanner;

class SumSeq
{
	public static void main(String args[])
	{
		// Check arguments
		if (args.length == 0)
		{
			System.out.println("Usage: java SumSeq <int> [<int> ...]");
			return;
		}


		int prev = 0;   // Previous number
		int count = 0;  // 'prev' occured 'count' times
		int sum = 0;    // Total sum of all parameters

		// Iterate through all parameters
		for (int i=0; i < args.length; i++)
		{
			Scanner sc = new Scanner(args[i]);

			// Check for valid integers
			if (!sc.hasNextInt())
			{
				System.out.printf("Error: '%s' is not an integer.\n", args[i]);
				return;
			}

			int n = sc.nextInt();

			// This is a new number, output the count (if any) of the previous one.
			if (n != prev)
			{
				if (count > 0)
				{
					System.out.printf("%d mal die Zahl %d\n", count, prev);
				}

				prev = n;
				count = 1;
			}
			else
			{
				// Nothing new, just increment the count
				count++;
			}

			sum += n;
		}

		// Output the last sequence...
		if (count > 0)
		{
			System.out.printf("%d mal die Zahl %d\n", count, prev);
		}
		// ... and the sum
		System.out.printf("Summe: %d\n", sum);
	}
}
