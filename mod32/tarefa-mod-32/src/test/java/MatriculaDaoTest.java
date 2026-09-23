import com.fabioperettig.dao.CursoDao;
import com.fabioperettig.dao.ICursoDao;
import com.fabioperettig.dao.IMatriculaDao;
import com.fabioperettig.dao.MatriculaDao;
import com.fabioperettig.domain.Curso;
import com.fabioperettig.domain.Matricula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDaoTest {

    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;
    private final List<Matricula> matriculasCriadas = new ArrayList<>();
    private final List<Curso> cursosCriados = new ArrayList<>();

    public MatriculaDaoTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
    }

    @AfterEach
    public void removerMatriculasCriadas() {
        for (Matricula matricula : matriculasCriadas) {
            Matricula encontrado = matriculaDao.readById(matricula.getId());
            if (encontrado != null) {
                matriculaDao.delete(encontrado);
            }
        }
        /// As matrículas precisam ser removidas antes dos cursos que elas referenciam.
        for (Curso curso : cursosCriados) {
            Curso encontrado = cursoDao.readById(curso.getId());
            if (encontrado != null) {
                cursoDao.delete(encontrado);
            }
        }
    }

    @Test
    public void cadastrarMatricula() {

        Curso curso = criarCursoTesteMatricula("CRS009", "Java Orientação de Objetos");

        Matricula matricula = new Matricula();
        matricula.setCodigo("MAT001");
        matricula.setValor(2000d);
        matricula.setCurso(curso);

        matriculaDao.create(matricula);
        matriculasCriadas.add(matricula);
        Assertions.assertNotNull(matricula.getId());
    }

    @Test
    public void buscarMatriculaPorId() {

        Curso curso = criarCursoTesteMatricula("CRS010", "Java Testes com JUnit");

        Matricula matricula = new Matricula();
        matricula.setCodigo("MAT002");
        matricula.setValor(2000d);
        matricula.setCurso(curso);

        matriculaDao.create(matricula);
        matriculasCriadas.add(matricula);
        Assertions.assertNotNull(matricula);
        Assertions.assertNotNull(matricula.getId());

        Matricula mResult = matriculaDao.readById(matricula.getId());
        Assertions.assertNotNull(mResult);
        Assertions.assertEquals(mResult.getDataMatricula(), matricula.getDataMatricula());
        Assertions.assertSame("MAT002", matricula.getCodigo());

    }

    @Test
    public void alterarMatricula() {

        Curso cursoBackend =  criarCursoTesteMatricula("CRS011", "Camada Services em Projetos DAO");
        Curso cursoFront =  criarCursoTesteMatricula("CRS012", "Responsividade CSS");
        cursoFront.setCategoria("frontend");

        Matricula matricula = new Matricula();
        matricula.setCodigo("MAT003");
        matricula.setValor(790d);
        matricula.setCurso(cursoFront);

        matriculaDao.create(matricula);
        matriculasCriadas.add(matricula);
        Assertions.assertNotNull(matricula);
        Assertions.assertSame("frontend", cursoFront.getCategoria());

        matricula.setCurso(cursoBackend);
        matriculaDao.update(matricula);

        Matricula mResult = matriculaDao.readById(matricula.getId());

        Assertions.assertNotNull(mResult);
        Assertions.assertEquals(cursoBackend.getId(),mResult.getCurso().getId());
    }

    @Test
    public void removerMatricula() {
        Curso curso = criarCursoTesteMatricula("CRS013", "Curso para deletar");

        Matricula matricula = new Matricula();
        matricula.setCodigo("MATDEL");
        matricula.setValor(000d);
        matricula.setCurso(curso);

        matriculaDao.create(matricula);
        matriculasCriadas.add(matricula);
        Assertions.assertNotNull(matricula);
        Assertions.assertNotNull(matricula.getId());

        matriculaDao.delete(matricula);

        Matricula matriculaDEL = matriculaDao.readById(matricula.getId());
        Assertions.assertNull(matriculaDEL);
    }


    @Test
    public void listarMatriculas() {
        List<Matricula> listaMatriculasEsperadas = new ArrayList<>();
        criarMatriculasLista(listaMatriculasEsperadas);

        List<Matricula> listaResult = matriculaDao.findAll();
        Assertions.assertNotNull(listaResult);

        for (Matricula esperada : listaMatriculasEsperadas) {
            Assertions.assertTrue(
                    listaResult.stream().anyMatch(
                            encontrada -> esperada.getId().equals(encontrada.getId())
                    )
            );
        }
    }

    @Test
    public void buscarPorNome() {
        Curso curso = criarCursoTesteMatricula("CRS015", "Java Filtro por Nome");
        criarCursoTesteMatricula("CRS016", "CSS Seletores");

        List<Curso> listaResult = matriculaDao.findByFilter("filtro por nome", null, null);

        Assertions.assertNotNull(listaResult);
        Assertions.assertTrue(listaResult.stream().anyMatch(
                encontrado -> curso.getId().equals(encontrado.getId())
        ));
        for (Curso encontrado : listaResult) {
            Assertions.assertTrue(encontrado.getNome().toLowerCase().contains("filtro por nome"));
        }
    }

    @Test
    public void buscarPorCodigo() {
        Curso curso = criarCursoTesteMatricula("CRS017", "Java Filtro por Código");
        criarCursoTesteMatricula("CRS018", "HTML Formulários");

        List<Curso> listaResult = matriculaDao.findByFilter(null, "CRS017", null);

        Assertions.assertNotNull(listaResult);
        Assertions.assertEquals(1, listaResult.size());
        Assertions.assertEquals(curso.getId(), listaResult.get(0).getId());
        Assertions.assertEquals("CRS017", listaResult.get(0).getCodigo());
    }

    @Test
    public void buscarPorCategoria() {
        Curso curso = criarCursoTesteMatricula("CRS019", "Java Filtro por Categoria");
        Curso cursoFront = criarCursoTesteMatricula("CRS020", "CSS Filtro por Categoria");
        cursoFront.setCategoria("frontend");
        cursoDao.update(cursoFront);

        List<Curso> listaResult = matriculaDao.findByFilter(null, null, "backend");

        Assertions.assertNotNull(listaResult);
        Assertions.assertTrue(listaResult.stream().anyMatch(
                encontrado -> curso.getId().equals(encontrado.getId())
        ));
        for (Curso encontrado : listaResult) {
            Assertions.assertEquals("backend", encontrado.getCategoria());
        }
    }

    ///auxiliar
    public List<Matricula> criarMatriculasLista(List<Matricula> listaMatriculas) {
        Curso curso = criarCursoTesteMatricula("CRS014", "Curso para listar matrículas");

        Matricula matricula1 = new Matricula();
        matricula1.setCodigo("MAT004");
        matricula1.setValor(2000d);
        matricula1.setCurso(curso);

        Matricula matricula2 = new Matricula();
        matricula2.setCodigo("MAT005");
        matricula2.setValor(790d);
        matricula2.setCurso(curso);

        matriculaDao.create(matricula1);
        matriculasCriadas.add(matricula1);
        matriculaDao.create(matricula2);
        matriculasCriadas.add(matricula2);

        listaMatriculas.add(matricula1);
        listaMatriculas.add(matricula2);

        return listaMatriculas;
    }

    public Curso criarCursoTesteMatricula(String codigo, String nome) {
        Curso curso = new Curso();
        curso.setCategoria("backend");
        curso.setCodigo(codigo);
        curso.setNome(nome);

        Curso cadastrado = cursoDao.create(curso);
        cursosCriados.add(cadastrado);
        return cadastrado;

    }
}
