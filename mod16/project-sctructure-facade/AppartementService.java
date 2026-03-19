
public class AppartementService implements iAppartement{

    @Override
    public boolean inscriteAppartement(Appartement appartement) {
        Boolean enregistre = estEnregistre(appartement);
        Boolean valides = sontChampsValides(appartement);

        if (enregistre || !valides){
            return false;
        }

        return inscrireDansLaBase(appartement);

    }

    /**
     * C'est ici que la logique d'enregistrement
     * est implémentée;
     *
     * @param appartement
     * @return
     * @author fabioperettig
     */
    private Boolean inscrireDansLaBase(Appartement appartement){
        return true;
    }

    /**
     * Vérifiez das la base de donnés (SQL)
     * si l'appartement est déjà enregistré;
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
     * Vérifiez que tous les champs d'inscrition
     * ont été correctement remplis.
     *
     * @param appartement
     * @return
     * @author fabioperettig
     */
    private Boolean sontChampsValides(Appartement appartement){
        return true;
    }
}
