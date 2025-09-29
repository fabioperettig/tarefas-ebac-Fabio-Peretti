public class Cafe
{
    private string tipoGrao;
    private string torra;
    public int intensidade;
    public double temperatura;
    public bool comAcucar;

    ///construtor
    public Cafe(string tipoGrao, string torra, int intensidade, double temperatura)
    {
        SetTipoGrao(tipoGrao);
        SetTorra(torra);
        this.intensidade = intensidade;
        setTemperatura(temperatura);
        this.comAcucar = false;
    }

    public string GetTipoGrao()
    {
        return tipoGrao;
    }

    /**
      * Define o tpo de grão do café.
      * Substitui valores nullos/vazios por Arábica por padrão
      * @param tipoGrao (Arábica, Robusta, Libérica, Excelsa)
     */

    public void setTipoGrao(string tipoGrao)
    {
        if (string.isNullOrEmpty(tipoGrao))
        {
            tipoGrao = "Arabica";
        }
        else
        {
            this.tipoGrao = tipoGrao;
        }
    }

    public string getTorra()
    {
        return torra;
    }


    /**
     * @deprecated substituido pelo método setTorra(String torra)
     * @param torra (Clara, Média, Escura)
     */
    public void setTorraCafe(string torra)
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

    public void setTorra(String torra) {
        if (torra.equalsIgnoreCase("clara") ||
                torra.equalsIgnoreCase("média") ||
                torra.equalsIgnoreCase("escura")) {
            this.torra = torra;
        } else {
            this.torra = "média"; // padrão
        }
    }
    

}