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

        Carro carro = criarCarroTest(
                "CarroTeste", "CRR000",
                "MarcaTeste", "MAR000");

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

        Carro carro = criarCarroTest(
                "CarroTeste", "CRR000",
                "MarcaTeste", "MAR000");

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

        Carro carro = criarCarroTest(
                "CarroTeste", "CRR000",
                "MarcaTeste", "MAR000");

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

        Carro carro = criarCarroTest(
                "CarroTeste", "CRR000",
                "MarcaTeste", "MAR000");

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

    @Test
    public void listarAcessoriosEmCarros() {

        List<Acessorio> listaAcessorios = new ArrayList<>();

        Carro c1 = criarCarroTest(
                "CarroTeste1", "CRR001",
                "MarcaTeste1", "MAR001");

        Carro c2 = criarCarroTest(
                "CarroTeste2", "CRR002",
                "MarcaTeste2", "MAR002");

        Carro c3 = criarCarroTest(
                "CarroTeste3", "CRR003",
                "MarcaTeste3", "MAR003");

        Assertions.assertNotNull(c1);
        Assertions.assertNotNull(c2);
        Assertions.assertNotNull(c3);

        Acessorio a1 = criarAcessorioTeste(c1, "ACS001");
        Acessorio a2 = criarAcessorioTeste(c2, "ACS002");
        Acessorio a3 = criarAcessorioTeste(c3, "ACS003");

        listaAcessorios.add(a1);
        listaAcessorios.add(a2);
        listaAcessorios.add(a3);

        acessorioDao.findAll();
        Assertions.assertNotNull(listaAcessorios);
        Assertions.assertSame(a2, listaAcessorios.get(1));
    }

    /// Metodo JPQL
    @Test
    public void buscarAcessorioPorCodigoCriteriaAPI() {
        listarAcessoriosEmCarros();
        Acessorio acessorio = acessorioDao.findyByCode("ACS002");

        Assertions.assertNotNull(acessorio);
        Assertions.assertEquals("ACS002", acessorio.getCodigo());
    }

    ///auxiliares
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

    public Carro criarCarroTest(String nomeCarro, String codigoCarro, String nomeMarca, String codigoMarca) {
        Carro carro = new Carro();
        Marca marca = criarMarcaTeste(nomeMarca, codigoMarca);
        carro.setMarca(marca);
        carro.setNome(nomeCarro);
        carro.setCodigo(codigoCarro);
        carro.setAno(2015);
        carro.setModelo("Sedan");

        Carro carroTeste = carroDao.create(carro);
        carrosCriados.add(carro);

        return carroTeste;
    }

    public Acessorio criarAcessorioTeste(Carro carro, String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Alarme");
        acessorio.setCodigo(codigo);
        acessorio.setCategoria("Segurança");
        acessorio.setValor(199.00);
        acessorio.setCarro(carro);

        Acessorio acessorioTeste = acessorioDao.create(acessorio);
        acessoriosCriados.add(acessorioTeste);

        return acessorioTeste;
    }
}
