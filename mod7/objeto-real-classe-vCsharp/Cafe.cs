using System;

public class Cafe
{
    private string tipoGrao;
    private string torra;
    public int Intensidade { get; set; }
    public double Temperatura { get; set; }
    public bool ComAcucar { get; private set; }


    /// construtor
    public Cafe(string tipoGrao, string torra, int intensidade, double temperatura)
    {
        SetTipoGrao(tipoGrao);
        SetTorra(torra);
        Intensidade = intensidade;
        SetTemperatura(temperatura);
        ComAcucar = false;
    }

    public string GetTipoGrao()
    {
        return tipoGrao;
    }

    /// <summary>
    /// Define o tipo de grão do café.
    /// Substitui valores nulos/vazios por Arábica por padrão.
    /// </summary>
    /// <param name="tipoGrao">Arábica, Robusta, Libérica, Excelsa</param>
    public void SetTipoGrao(string tipoGrao)
    {
        if (string.IsNullOrEmpty(tipoGrao))
        {
            this.tipoGrao = "Arabica";
        }
        else
        {
            this.tipoGrao = tipoGrao;
        }
    }

    public string GetTorra()
    {
        return torra;
    }


    /// <summary>
    /// Método obsoleto, substituido pelo SetTorra(string torra)
    /// </summary>
    /// <param name="torra"></param>
    [Obsolete("substituido pelo SetTorra(string torra)")]
    public void SetTorraCafe(string torra)
    {
        if (torra.Equals("Torra Clara"))
        {
            this.torra = "Torra Clara";
        }
        else if (torra.Equals("Torra Média"))
        {
            this.torra = "Torra Média";
        }
        else
        {
            this.torra = "Torra Escura";
        }
    }

    public void SetTorra(String torra)
    {
        if (torra.Equals("clara", StringComparison.OrdinalIgnoreCase) ||
            torra.Equals("média", StringComparison.OrdinalIgnoreCase) ||
            torra.Equals("escura", StringComparison.OrdinalIgnoreCase))
        {
            this.torra = torra;
        }
        else
        {
            this.torra = "média"; // padrão
        }
    }

    public void Adocar()
    {
        if (!ComAcucar)
        {
            ComAcucar = true;
            Console.WriteLine("Café adoçado.");
        }
        else
        {
            Console.WriteLine("O café já foi adoçado.");
        }
    }

    public void Esfriar()
    {
        Temperatura -= 5;
        Console.WriteLine($"O café esfriou. Temperatura atual: {Temperatura}°C");
    }

    public void Status()
    {
        Console.WriteLine($"Café: {tipoGrao} ({torra})");
        Console.WriteLine($"Intensidade: {Intensidade}");
        Console.WriteLine($"Temperatura: {Temperatura}°C");
        Console.WriteLine($"Adoçado: {(ComAcucar ? "Sim" : "Não")}");
    }


}