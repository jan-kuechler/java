// Berechnung von pi
// Autor:  Sebastian Birk
// Version: 14.04.2011
// fehlerhaftes Programm zu Blatt 2, Aufgabe 3

import java.util.Scanner;

public class Pi
{
  static double f(double x)
  {
    return 4 / (1 + x^2)
  }

  public void main(String[] args)
  {
    System.out("n = ");
    int n = (new Scanner(System.in)).nextInt;

    double sum;
    double h = 1 / n;
    sum = f(0) + f(1);
    for int i = 1; i < n; i++
      sum += 2 * f(i * h);
    sum *= h / 2;

    System.out.println("result: " + sum);
    System.out.println("error:  " + abs(sum - PI));
  }
};