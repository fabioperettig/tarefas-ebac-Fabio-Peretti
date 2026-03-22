## Projeto Orientado a Objeto Java – Objeto Real ##

Este repositório faz parte do Curso de Java Back End da EBAC 🎓.  
O objetivo aqui é demonstrar em uma Classe simples como um objeto real seria descrito, tanto em suas características, quanto em suas mecânicas de comportamento.

````
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
}
````
---

### Encapsulamento ### 

Tomei a liberdade de determinar algumas propriedades da Classe como privadas para desenvolver e evidenciar o uso de Getters e Setters ao projeto. Além disso, o uso de cometários estruturados também foi usado para facilitar a compreenção de métodos "set" mais complexos.

````
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

````
---


### @deprecated ###

Por fim, também foi simulado uma obsolencência e substituição de métodos, relatado através do método "@deprecated".

````
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
````