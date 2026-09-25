import com.fabioperettig.dao.CarroDao;
import com.fabioperettig.dao.ICarroDao;
import com.fabioperettig.dao.IMarcaDao;
import com.fabioperettig.dao.MarcaDao;
import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarroDaoTest {

    private final IMarcaDao marcaDao;
    private final ICarroDao carroDao;
    private final List<Carro> carrosCriados = new ArrayList<>();
    private final List<Marca> marcasCriadas = new ArrayList<>();

    public CarroDaoTest() {
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
    }

    @AfterEach
    public void removerCarros() {
        for(Carro carro : carrosCriados) {
            Carro cEncontrado = carroDao.read(carro.getId());
            if (cEncontrado != null) {
                carroDao.delete(cEncontrado);
            }
        }

        for (Marca marca : marcasCriadas) {
            Marca mEncontrada = marcaDao.read(marca.getId());
            if (mEncontrada != null) {
                marcaDao.delete(mEncontrada);
            }
        }
    }

    @Test
    public void cadastrarCarro() {

        Marca mTeste = criarMarcaTeste("Volkswagen", "MAR001");
        Assertions.assertNotNull(mTeste);

        Carro carro = new Carro();
        carro.setMarca(mTeste);
        carro.setNome("Gol G6");
        carro.setCodigo("CRR001");
        carro.setAno(1980);
        carro.setModelo("Hatch");

        carroDao.create(carro);
        carrosCriados.add(carro);
        Assertions.assertNotNull(carro);
    }

    @Test
    public void buscarCarroPorId() {

        Marca mTeste = criarMarcaTeste("Toyota", "MAR002");
        Assertions.assertNotNull(mTeste);

        Carro carro = new Carro();
        carro.setMarca(mTeste);
        carro.setNome("Corolla");
        carro.setCodigo("CRR002");
        carro.setAno(2008);
        carro.setModelo("Sedan");

        carroDao.create(carro);
        carrosCriados.add(carro);
        Assertions.assertNotNull(carro);

        Carro cResult = carroDao.read(carro.getId());
        Assertions.assertNotNull(cResult);
        Assertions.assertEquals(cResult.getNome(), carro.getNome());
        Assertions.assertSame("CRR002", carro.getCodigo());
    }

    @Test
    public void atualizarCarro() {
        Marca mTeste = criarMarcaTeste("Ford", "MAR003");
        Assertions.assertNotNull(mTeste);

        Carro carro = new Carro();
        carro.setMarca(mTeste);
        carro.setNome("Maveric");
        carro.setCodigo("CRR002");
        carro.setAno(1973);
        carro.setModelo("Esporte");

        carroDao.create(carro);
        carrosCriados.add(carro);
        Assertions.assertNotNull(carro);

        carro.setNome("Maverick");
        carro.setCodigo("CRR003");
        carroDao.update(carro);

        Assertions.assertSame("CRR003", carro.getCodigo());
        Assertions.assertSame("Maverick", carro.getNome());
    }

    @Test
    public void removerCarro() {
        Marca mTeste = criarMarcaTeste("Citroen", "MAR004");
        Assertions.assertNotNull(mTeste);

        Carro carro = new Carro();
        carro.setMarca(mTeste);
        carro.setNome("C4");
        carro.setCodigo("CRR004");
        carro.setAno(2015);
        carro.setModelo("Sedan");

        carroDao.create(carro);
        carrosCriados.add(carro);
        Assertions.assertNotNull(carro);

        carroDao.delete(carro);

        Carro cResultDEL = carroDao.read(carro.getId());
        Assertions.assertNull(cResultDEL);
    }

    @Test
    public void listarCarros() {
        Marca mTeste = criarMarcaTeste("Chevrolet", "MAR005");
        Assertions.assertNotNull(mTeste);

        List<Carro> listaCarros = new ArrayList<>();

        Carro carro1 = new Carro();
        carro1.setMarca(mTeste);
        carro1.setNome("C4");
        carro1.setCodigo("CRR005");
        carro1.setAno(2015);
        carro1.setModelo("Sedan");

        Carro carro2 = new Carro();
        carro2.setMarca(mTeste);
        carro2.setNome("C4");
        carro2.setCodigo("CRR006");
        carro2.setAno(2015);
        carro2.setModelo("Sedan");

        Carro carro3 = new Carro();
        carro3.setMarca(mTeste);
        carro3.setNome("C4");
        carro3.setCodigo("CRR007");
        carro3.setAno(2015);
        carro3.setModelo("Sedan");

        Carro carro4 = new Carro();
        carro4.setMarca(mTeste);
        carro4.setNome("C4");
        carro4.setCodigo("CRR008");
        carro4.setAno(2015);
        carro4.setModelo("Sedan");

        carroDao.createAll(carro1, carro2, carro3, carro4);

        listaCarros.add(carro1);
        listaCarros.add(carro2);
        listaCarros.add(carro3);
        listaCarros.add(carro4);


        ///adicionar à lista AfterEach
        carrosCriados.add(carro1);
        carrosCriados.add(carro2);
        carrosCriados.add(carro3);
        carrosCriados.add(carro4);

        Assertions.assertNotNull(listaCarros);
        Assertions.assertSame(carro2, listaCarros.get(1));

    }



    public Marca criarMarcaTeste(String nome, String codigo) {
        Marca marca = new Marca();
        marca.setNome(nome);
        marca.setCodigo(codigo);
        marca.setAno(1950);
        marca.setOrigem("OrigemTeste");

        Marca marcaTeste = marcaDao.create(marca);
        marcasCriadas.add(marca);

        return marcaTeste;
    }

}
