package br.com.fabioperettig.root;

public class Customer {

    private String numRequest;
    private String socialAquisition;
    private boolean insurancePlan;


    public Customer(String numRequest, String socialAquisition, boolean hasInsurance) {
        this.numRequest = numRequest;
        this.socialAquisition = socialAquisition;
        this.insurancePlan = hasInsurance;
    }

    public boolean hasInsurance(){
        return insurancePlan;
    }

    public String getNumRequest(){
        return numRequest;
    }

    public String getSocialAquisition(){
        return socialAquisition;
    }

}
