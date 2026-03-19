public class Main {
    /**
     * That's a perfect example of 'Anonymous Instantiation' {@code service.registerApartment(new Apartment(...))}
     * The object is created as method param, without being stored in a variable.
     * {@code service.registerApartment(new Apartment(190326, "Cobbled Creek Apartment"));}
     * Is the same of
     * {@code Apartment myHome = new Apartment();}
     * {@code service.registerApartment(myHome);}
     *
     * This sort of 'anonymous/temporary instance' is frequently used in structural patterns
     * because these objects exists just to deliver data from A to B point and being deleted
     * soon after, or used as a behavioral test and keep memory cache clean.
     */
    public static void main(String[] args) {

        iApartment service = new AppartementService();
        service.registerApartment(new Apartment(190326, "Cobbled Creek Apartment"));//*

    }

}
