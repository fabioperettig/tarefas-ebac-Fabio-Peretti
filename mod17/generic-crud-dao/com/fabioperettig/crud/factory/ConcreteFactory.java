package com.fabioperettig.crud.factory;

public class ConcreteFactory implements IFactory{

    @Override
    public FactoryPersistent createFabric(String menuOption) {

        return switch (menuOption) {
            case "Client" -> new ClientFactory();
            case "Product" -> new ProductFactory();
            default -> null;
        };
    }

}
