package br.com.fabioperettig.root;

public class Customer {

    private String numRequest;
    private String socialAquisition;


    public Customer(String numRequest, String socialAquisition) {
        this.numRequest = numRequest;
        this.socialAquisition = socialAquisition;
    }

    public String getNumRequest(){
        return numRequest;
    }

    public String getSocialAquisition(){
        return socialAquisition;
    }

}
