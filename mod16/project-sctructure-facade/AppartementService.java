
public class AppartementService implements iApartment{

    @Override
    public boolean registerApartment(Apartment apartment) {
        Boolean registered = isRegistered(apartment);
        Boolean valid = isValid(apartment);

        if (registered || !valid){
            return false;
        }

        return registerInDatabase(apartment);

    }

    /**
     * Cette méthode implémente
     * la logique d'enregistrement.
     *
     * @param apartment
     * @return
     * @author fabioperettig
     */
    private Boolean registerInDatabase(Apartment apartment){
        return true;
    }

    /**
     * Vérifier dans la base de données
     * si l'appartement est déjà enregistré.
     *
     * @param apartment
     * @return
     * @author fabioperettig
     */
    private Boolean isRegistered(Apartment apartment){
        //Vérifiez das la base de donnés (SQL)
        // si l'appartement est déjà enregistré;
        return false;
    }

    /**
     * Vérifiez que tous les champs d'inscription
     * ont été correctement remplis.
     *
     * @param apartment
     * @return
     * @author fabioperettig
     */
    private Boolean isValid(Apartment apartment){
        return true;
    }
}
