// Berechnung von pi
// Autor:  Sebastian Birk
// Version: 14.04.2011
// fehlerhaftes Programm zu Blatt 2, Aufgabe 3

import java.util.Scanner;

public class pi //! "pi" klein, wie der Dateiname
{
  static double f(double x)
  {
    return 4 / (1 + x*x); //! kein ^-Operator für Potenzen, Semikolon fehlt
  }

  public static void main(String[] args) //! static fehlt
  {
    System.out.print("n = "); //! Fehlender Funktionsaufruf
    int n = (new Scanner(System.in)).nextInt(); //! Klammern fehlen

    double sum;
    double h = (double)1 / n; //! int/int gibt int, das ist wohl nicht das gewünschte...
    sum = f(0) + f(1);
    for (int i = 1; i < n; i++) //! Klammern fehlen
      sum += 2 * f(i * h);
    sum *= h / 2;

    System.out.println("result: " + sum);
    System.out.println("error:  " + Math.abs(sum - Math.PI)); //! Math.abs() und Math.PI
  }
};