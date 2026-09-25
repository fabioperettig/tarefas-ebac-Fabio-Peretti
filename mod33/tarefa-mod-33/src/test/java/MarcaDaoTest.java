import com.fabioperettig.dao.IMarcaDao;
import com.fabioperettig.dao.MarcaDao;
import com.fabioperettig.domain.Marca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MarcaDaoTest {

    private final IMarcaDao marcaDao;
    private final List<Marca> marcasCriadas = new ArrayList<>();

    public MarcaDaoTest() {
        marcaDao = new MarcaDao();
    }

    @AfterEach
    public void removerMarcas() {
        for (Marca marca : marcasCriadas) {
            Marca mEncontrada = marcaDao.read(marca.getId());
            if (mEncontrada != null) {
                marcaDao.delete(mEncontrada);
            }
        }
    }

    @Test
    public void cadastrarMarca() {
        Marca marca = new Marca();
        marca.setNome("Volkswagen");
        marca.setCodigo("MAR001");
        marca.setAno(1937);
        marca.setOrigem("Alemanha");

        marcaDao.create(marca);
        marcasCriadas.add(marca);
        Assertions.assertNotNull(marca);
    }

    @Test
    public void buscarMarcaPorId() {
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marca.setCodigo("MAR002");
        marca.setAno(1937);
        marca.setOrigem("Japão");

        marcaDao.create(marca);
        marcasCriadas.add(marca);
        Assertions.assertNotNull(marca);

        Marca mResult = marcaDao.read(marca.getId());
        Assertions.assertNotNull(mResult);
        Assertions.assertEquals(mResult.getNome(), marca.getNome());
        Assertions.assertSame("MAR002", marca.getCodigo());
    }

    @Test
    public void atualizarMarca() {
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marca.setCodigo("MAR002");
        marca.setAno(1930);
        marca.setOrigem("Japão");

        marcaDao.create(marca);
        marcasCriadas.add(marca);
        Assertions.assertNotNull(marca);

        marca.setNome("Ford");
        marca.setCodigo("MAR003");
        marca.setAno(1903);
        marca.setOrigem("EUA");
        marcaDao.update(marca);

        Assertions.assertSame("MAR003", marca.getCodigo());
        Assertions.assertEquals(1903, marca.getAno());
    }

    @Test
    public void removerMarca() {
        Marca marca = new Marca();
        marca.setNome("Peugeot");
        marca.setCodigo("MAR004");
        marca.setAno(1810);
        marca.setOrigem("França");

        marcaDao.create(marca);
        marcasCriadas.add(marca);
        Assertions.assertNotNull(marca);

        marcaDao.delete(marca);

        Marca mResultDEL = marcaDao.read(marca.getId());
        Assertions.assertNull(mResultDEL);
    }

    @Test
    public void listarMarcas() {

        List<Marca> listaMarcas = new ArrayList<>();

        Marca marca1 = new Marca();
        marca1.setNome("Volkswagen");
        marca1.setCodigo("MAR001");
        marca1.setAno(1937);
        marca1.setOrigem("Alemanha");

        Marca marca2 = new Marca();
        marca2.setNome("Toyota");
        marca2.setCodigo("MAR002");
        marca2.setAno(1937);
        marca2.setOrigem("Japão");

        Marca marca3 = new Marca();
        marca3.setNome("Ford");
        marca3.setCodigo("MAR003");
        marca3.setAno(1903);
        marca3.setOrigem("EUA");

        Marca marca4 = new Marca();
        marca4.setNome("Peugeot");
        marca4.setCodigo("MAR004");
        marca4.setAno(1810);
        marca4.setOrigem("França");

        marcaDao.createAll(marca1, marca2, marca3, marca4);

        listaMarcas.add(marca1);
        listaMarcas.add(marca2);
        listaMarcas.add(marca3);
        listaMarcas.add(marca4);

        ///adicionar à lista AfterEach
        marcasCriadas.add(marca1);
        marcasCriadas.add(marca2);
        marcasCriadas.add(marca3);
        marcasCriadas.add(marca4);

        Assertions.assertNotNull(listaMarcas);
        Assertions.assertSame(marca3, listaMarcas.get(2));

    }

}
