import com.fabioperettig.dao.CursoDao;
import com.fabioperettig.dao.ICursoDao;
import com.fabioperettig.domain.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        curso.setCodigo("CRS000");
        curso.setNome("JDBC");

        cursoDao.create(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());

        cursoDao.delete(curso);

        Curso cursoDEL = cursoDao.readById(curso.getId());
        Assertions.assertNull(cursoDEL);
    }

    @Test
    public void listarCursos() {

        List<Curso> listaCursosEsperados = new ArrayList<>();
        criarCursosLista(listaCursosEsperados);
        Assertions.assertNotNull(listaCursosEsperados);

        List<Curso> listaResult = cursoDao.findAll();
        Assertions.assertNotNull(listaResult);

        for (Curso esperado : listaCursosEsperados) {
            Assertions.assertTrue(
                    listaResult.stream().anyMatch(
                            encontrado -> esperado.getId().equals(encontrado.getId())
                    )
            );
        }

    }

    public List<Curso> criarCursosLista(List<Curso> listaCursos) {

        Curso curso1 = new Curso();
        curso1.setCategoria("frontend");
        curso1.setCodigo("CRS004");
        curso1.setNome("HTML5");

        Curso curso2 = new Curso();
        curso2.setCategoria("backend");
        curso2.setCodigo("CRS005");
        curso2.setNome("Spring Boot");

        Curso curso3 = new Curso();
        curso3.setCategoria("database");
        curso3.setCodigo("CRS006");
        curso3.setNome("PSQL");

        Curso curso4 = new Curso();
        curso4.setCategoria("backend");
        curso4.setCodigo("CRS007");
        curso4.setNome("Java - Implementando com Generics");

        cursoDao.create(curso1);
        cursoDao.create(curso2);
        cursoDao.create(curso3);
        cursoDao.create(curso4);

        listaCursos.add(curso1);
        listaCursos.add(curso2);
        listaCursos.add(curso3);
        listaCursos.add(curso4);

        return listaCursos;
    }

}
