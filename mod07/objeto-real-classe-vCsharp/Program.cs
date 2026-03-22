using System;

public class Program
{
    public static void Main(string[] args)
    {
        Cafe cafe1 = new Cafe("Arabica", "Torra Clara", 10, 100);

        cafe1.Status();
        cafe1.Esfriar();
        cafe1.Status();
        cafe1.Adocar();
        cafe1.Status();

        
    }
}