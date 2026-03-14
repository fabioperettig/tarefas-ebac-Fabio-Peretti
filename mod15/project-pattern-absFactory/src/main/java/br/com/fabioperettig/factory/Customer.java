package br.com.fabioperettig.factory;

public class Customer {

    private String gradeRequest;
    private boolean hasBusinessContract;

    public Customer(String gradeRequest, boolean hasBusinessContract) {
        this.gradeRequest = gradeRequest;
        this.hasBusinessContract = hasBusinessContract;
    }

    public boolean HasBusinessContract() {
        return hasBusinessContract;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }

}
