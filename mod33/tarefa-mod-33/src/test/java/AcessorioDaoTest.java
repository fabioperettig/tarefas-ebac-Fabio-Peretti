import com.fabioperettig.dao.*;
import com.fabioperettig.domain.Acessorio;
import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AcessorioDaoTest {

    private final IMarcaDao marcaDao;
    private final ICarroDao carroDao;
    private final IAcessorioDao acessorioDao;
    private final List<Carro> carrosCriados = new ArrayList<>();
    private final List<Marca> marcasCriadas = new ArrayList<>();
    private final List<Acessorio> acessoriosCriados = new ArrayList<>();

    public AcessorioDaoTest() {
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
        acessorioDao = new AcessorioDao();
    }

    @AfterEach
    public void removerAcessorios() {
        for (Acessorio acessorio : acessoriosCriados) {
            Acessorio aEncontrado = acessorioDao.read(acessorio.getId());
            if (aEncontrado != null) {
                acessorioDao.delete(aEncontrado);
            }
        }

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
    public void cadastrarAcessorio() {

        Carro carro = criarCarroTest();
        Assertions.assertNotNull(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Spoiler GT");
        acessorio.setCodigo("ACS001");
        acessorio.setCategoria("Esporte");
        acessorio.setValor(250.00);
        acessorio.setCarro(carro);

        acessorioDao.create(acessorio);
        acessoriosCriados.add(acessorio);
        Assertions.assertNotNull(acessorio);
    }

    @Test
    public void buscarAcessorioPorId() {

        Carro carro = criarCarroTest();
        Assertions.assertNotNull(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Subwoofer");
        acessorio.setCodigo("ACS002");
        acessorio.setCategoria("Urbano");
        acessorio.setValor(90.00);
        acessorio.setCarro(carro);

        acessorioDao.create(acessorio);
        acessoriosCriados.add(acessorio);
        Assertions.assertNotNull(acessorio);

        Acessorio aResult = acessorioDao.read(acessorio.getId());
        Assertions.assertNotNull(aResult);
        Assertions.assertEquals(aResult.getNome(), acessorio.getNome());
        Assertions.assertSame("ACS002", acessorio.getCodigo());
    }

    @Test
    public void atualizarAcessorio() {

        Carro carro = criarCarroTest();
        Assertions.assertNotNull(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("RVC");
        acessorio.setCodigo("ACS003");
        acessorio.setCategoria("Tech");
        acessorio.setValor(3020.00);
        acessorio.setCarro(carro);

        acessorioDao.create(acessorio);
        acessoriosCriados.add(acessorio);
        Assertions.assertNotNull(acessorio);

        acessorio.setNome("RVC (Rear View Camera)");
        acessorio.setValor(320.00);
        acessorioDao.update(acessorio);

        Assertions.assertSame("ACS003", acessorio.getCodigo());
        Assertions.assertEquals(320.00, acessorio.getValor());
    }

    @Test
    public void removerAcessorio() {

        Carro carro = criarCarroTest();
        Assertions.assertNotNull(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Rastreador");
        acessorio.setCodigo("ACS004");
        acessorio.setCategoria("Segurança");
        acessorio.setValor(450.00);
        acessorio.setCarro(carro);

        acessorioDao.create(acessorio);
        acessoriosCriados.add(acessorio);
        Assertions.assertNotNull(acessorio);

        acessorioDao.delete(acessorio);

        Acessorio aResultDEL = acessorioDao.read(acessorio.getId());
        Assertions.assertNull(aResultDEL);
    }


    ///auxiliares
    public Marca criarMarcaTeste() {
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marca.setCodigo("MAR001");
        marca.setAno(1950);
        marca.setOrigem("OrigemTeste");

        Marca marcaTeste = marcaDao.create(marca);
        marcasCriadas.add(marca);

        return marcaTeste;
    }

    public Carro criarCarroTest() {
        Carro carro = new Carro();
        Marca marca = criarMarcaTeste();
        carro.setMarca(marca);
        carro.setNome("Corolla");
        carro.setCodigo("CRR001");
        carro.setAno(2015);
        carro.setModelo("Sedan");

        Carro carroTeste = carroDao.create(carro);
        carrosCriados.add(carro);

        return carroTeste;
    }
}
