
public class AppartementService implements iAppartement{

    @Override
    public boolean inscrireAppartement(Appartement appartement) {
        Boolean dejaEnregistre = estEnregistre(appartement);
        Boolean estValide = champsSontValides(appartement);

        if (dejaEnregistre || !estValide){
            return false;
        }

        return inscrireDansLaBase(appartement);

    }

    /**
     * Cette méthode implémente
     * la logique d'enregistrement.
     *
     * @param appartement
     * @return
     * @author fabioperettig
     */
    private Boolean inscrireDansLaBase(Appartement appartement){
        return true;
    }

    /**
     * Vérifier dans la base de données
     * si l'appartement est déjà enregistré.
     *
     * @param appartement
     * @return
     * @author fabioperettig
     */
    private Boolean estEnregistre(Appartement appartement){
        //Vérifiez das la base de donnés (SQL)
        // si l'appartement est déjà enregistré;
        return false;
    }

    /**
     * Vérifiez que tous les champs d'inscription
     * ont été correctement remplis.
     *
     * @param appartement
     * @return
     * @author fabioperettig
     */
    private Boolean champsSontValides(Appartement appartement){
        return true;
    }
}
