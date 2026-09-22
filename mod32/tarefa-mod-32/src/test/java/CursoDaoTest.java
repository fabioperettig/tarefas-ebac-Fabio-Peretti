import com.fabioperettig.dao.CursoDao;
import com.fabioperettig.dao.ICursoDao;
import com.fabioperettig.domain.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoDaoTest {

    private ICursoDao cursoDao;

    public CursoDaoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrarCurso() {
        Curso curso = new Curso();
        curso.setCategoria("backend");
        curso.setCodigo("CRS001");
        curso.setNome("Java OOP");

        cursoDao.create(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());
    }

    @Test
    public void buscarCursoPorID(){
        Curso curso = new Curso();
        curso.setCategoria("backend");
        curso.setCodigo("CRS002");
        curso.setNome("Backend DAO");

        cursoDao.create(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());

        Curso cursoResult = cursoDao.readById(curso.getId());
        Assertions.assertNotNull(cursoResult);
        Assertions.assertEquals(cursoResult.getNome(), curso.getNome());
        Assertions.assertSame("CRS002", curso.getCodigo());
    }

    @Test
    public void atualizarCurso() {
        Curso curso = new Curso();
        curso.setCategoria("backend");
        curso.setCodigo("CRS00");
        curso.setNome("JPA");

        cursoDao.create(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());

        curso.setCodigo("CRS003");
        curso.setNome("Jakarta Persistence API");
        cursoDao.update(curso);

        Assertions.assertSame("CRS003", curso.getCodigo());
        Assertions.assertSame("Jakarta Persistence API", curso.getNome());
    }

    @Test
    public void removerCurso() {
        Curso curso = new Curso();
        curso.setCategoria("backend");
        curso.setCodigo("CRS004");
        curso.setNome("JDBC");

        cursoDao.create(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());

        cursoDao.delete(curso);

        Curso cursoDEL = cursoDao.readById(curso.getId());
        Assertions.assertNull(cursoDEL);
    }

}
