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
        marca.setNome("Honda");
        marca.setCodigo("MAR001");
        marca.setAno(1930);
        marca.setOrigem("Alemanha");

        marcaDao.create(marca);
        marcasCriadas.add(marca);

        Assertions.assertNotNull(marca);
    }

}
