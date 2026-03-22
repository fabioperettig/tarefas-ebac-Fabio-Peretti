/**
 *  Lição EBAC – Classe de objeto real (Café)
 *
 * @author Fabio Peretti
 * @version 1.0
 */

public class Cafe {

    private String tipoGrao;
    private String torra;
    public int intensidade;
    public double temperatura;
    public boolean comAcucar;

    public Cafe(String tipoGrao, String torra, int intensidade, double temperatura) {
        setTipoGrao(tipoGrao);
        setTorra(torra);
        this.intensidade = intensidade;
        setTemperatura(temperatura);
        this.comAcucar = false;
    }

    public String getTipoGrao() {
        return tipoGrao;
    }

    /**
     * Define o tpo de grão do café.
     * Substitui valores nullos/vazios por Arábica por padrão
     * @param tipoGrao (Arábica, Robusta, Libérica, Excelsa)
     */
    public void setTipoGrao(String tipoGrao){
        if (tipoGrao == null || tipoGrao.isEmpty()){
            this.tipoGrao = "Arábica"; //padrão
        } else {
            this.tipoGrao = tipoGrao;
        }
    }

    public String getTorra(){
        return torra;
    }

    /**
     * @deprecated substituido pelo método setTorra(String torra)
     * @param torra (Clara, Média, Escura)
     */
    public void setTorraCafe(String torra){
        if (torra.equals("Torra Clara")){
            this.torra = torra;
        } else if (torra.equals("Torra Média")) {
            this.torra = torra;
        } else if (torra.equals("Torra Escura")) {
            this.torra = torra;
        } else {
            this.torra = torra;
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


    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void adocar(){
        if (this.comAcucar) {
            System.out.println("O café já foi adoçado.");
        } else {
          this.comAcucar = true;
          System.out.println("Café adoçado.");
        }
    }

    /**
     * Exibe no console o status atual do café.
     */
    public void status() {

        System.out.println("Café: " + tipoGrao + " (" + torra + ")");
        System.out.println("Intensidade: " + intensidade);

        if (temperatura > 100) {
            System.out.println("Temperatura: " + temperatura + "°C");
            System.out.println("O café muito quente");
        } else if (temperatura < 50.0) {
            System.out.println("Temperatura: " + temperatura + "°C");
            System.out.println("O café está frio");
        } else {
            System.out.println("Temperatura: " + temperatura + "°C");
        }

        System.out.println("Adoçado: " + (comAcucar ? "Sim" : "Não"));
    }

    public void esfriar() {
        if (temperatura >= 50.0) {
            temperatura -= 5;
            System.out.println("A temperatura é de " + temperatura + "°C");
        }
    }
}
