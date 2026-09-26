package com.fabioperettig;

import com.fabioperettig.dao.CarroDao;
import com.fabioperettig.dao.ICarroDao;
import com.fabioperettig.dao.IMarcaDao;
import com.fabioperettig.dao.MarcaDao;
import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;

public class Main {

    public static Marca marca;

    public static void main(String[] args) {

        IMarcaDao marcaDao = new MarcaDao();
        ICarroDao carroDao = new CarroDao();

        marca = new Marca();
        marca.setNome("MarcaCarro");
        marca.setCodigo("M001");
        marca.setAno(1990);
        marca.setOrigem("Brasil");
        marcaDao.create(marca);

        ///CRIAR CARROS
        Carro carro1 = new Carro();
        carro1.setMarca(marca);
        carro1.setNome("CarroVermelho");
        carro1.setCodigo("CRR001");
        carro1.setAno(2015);
        carro1.setModelo("Sedan");

        Carro carro2 = new Carro();
        carro2.setMarca(marca);
        carro2.setNome("CarroAzul");
        carro2.setCodigo("CRR002");
        carro2.setAno(2015);
        carro2.setModelo("Hatch");

        Carro carro3 = new Carro();
        carro3.setMarca(marca);
        carro3.setNome("CarroVerde");
        carro3.setCodigo("CRR003");
        carro3.setAno(2015);
        carro3.setModelo("SUV");

        carroDao.create(carro1);
        carroDao.create(carro2);
        carroDao.create(carro3);

        Carro cResult = carroDao.findyByCode("CRR002");

        System.out.println(cResult.toString());
    }
}
