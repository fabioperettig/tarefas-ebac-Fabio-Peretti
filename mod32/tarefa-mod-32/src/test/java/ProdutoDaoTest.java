import com.fabioperettig.dao.ProdutoDao;
import com.fabioperettig.domain.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoTest {

    private final ProdutoDao produtoDao;
    private final List<Produto> produtosCriados = new ArrayList<>();

    public ProdutoDaoTest() {
        produtoDao = new ProdutoDao();
    }

    @AfterEach
    public void removerProdutosCriados() {
        for (Produto produto : produtosCriados) {
            Produto encontrado = produtoDao.readById(produto.getId());
            if (encontrado != null) {
                produtoDao.delete(encontrado);
            }
        }
    }

    @Test
    public void cadastrarProduto() {
        Produto produto = criarProdutoTeste("PRD001", "Teclado", 150d);

        Assertions.assertNotNull(produto);
        Assertions.assertNotNull(produto.getId());

        Produto produtoResult = produtoDao.readById(produto.getId());
        Assertions.assertNotNull(produtoResult);
        Assertions.assertEquals(produto.getId(), produtoResult.getId());
        Assertions.assertEquals("PRD001", produtoResult.getCode());
        Assertions.assertEquals("Teclado", produtoResult.getName());
    }

    @Test
    public void buscarProdutoPorId() {
        Produto produto = criarProdutoTeste("PRD002", "Mouse", 79.90d);

        Produto produtoResult = produtoDao.readById(produto.getId());

        Assertions.assertNotNull(produtoResult);
        Assertions.assertEquals(produto.getId(), produtoResult.getId());
        Assertions.assertEquals(produto.getCode(), produtoResult.getCode());
        Assertions.assertEquals(produto.getName(), produtoResult.getName());
    }

    @Test
    public void atualizarProduto() {
        Produto produto = criarProdutoTeste("PRD003", "Monitor", 900d);

        produto.setCode("PRD003ALT");
        produto.setName("Monitor LED");
        produto.setValue(1100.50d);
        Produto atualizado = produtoDao.update(produto);

        Produto produtoResult = produtoDao.readById(produto.getId());
        Assertions.assertNotNull(produtoResult);
        Assertions.assertEquals(produto.getId(), produtoResult.getId());
        Assertions.assertEquals("PRD003ALT", produtoResult.getCode());
        Assertions.assertEquals("Monitor LED", produtoResult.getName());


        Assertions.assertNotNull(atualizado);
        Assertions.assertEquals(produto.getId(), atualizado.getId());
        Assertions.assertEquals(produtoResult.getCode(), atualizado.getCode());
        Assertions.assertEquals(produtoResult.getName(), atualizado.getName());
    }

    @Test
    public void removerProduto() {
        Produto produto = criarProdutoTeste("PRD004", "Cabo HDMI", 35d);
        Assertions.assertNotNull(produtoDao.readById(produto.getId()));

        produtoDao.delete(produto);

        Assertions.assertNull(produtoDao.readById(produto.getId()));
    }

    @Test
    public void listarProdutos() {
        List<Produto> listaProdutosEsperados = new ArrayList<>();
        listaProdutosEsperados.add(criarProdutoTeste("PRD005", "Headset", 250d));
        listaProdutosEsperados.add(criarProdutoTeste("PRD006", "Webcam", 180d));
        listaProdutosEsperados.add(criarProdutoTeste("PRD007", "Microfone", 320d));

        List<Produto> listaResult = produtoDao.findAll();

        Assertions.assertNotNull(listaResult);
        for (Produto esperado : listaProdutosEsperados) {
            Assertions.assertTrue(listaResult.stream().anyMatch(
                    encontrado -> esperado.getId() == encontrado.getId()
            ));
        }
    }

    @Test
    public void buscarProdutoPorCodigo() {
        Produto produto = criarProdutoTeste("PRD008", "SSD", 399.90d);
        criarProdutoTeste("PRD009", "HD Externo", 299.90d);

        Produto produtoResult = produtoDao.findByCode("PRD008");

        Assertions.assertNotNull(produtoResult);
        Assertions.assertEquals(produto.getId(), produtoResult.getId());
        Assertions.assertEquals("PRD008", produtoResult.getCode());
        Assertions.assertEquals("SSD", produtoResult.getName());
    }

    private Produto criarProdutoTeste(String codigo, String nome, double valor) {
        Produto produto = new Produto();
        produto.setCode(codigo);
        produto.setName(nome);
        produto.setValue(valor);

        Produto cadastrado = produtoDao.create(produto);
        produtosCriados.add(produto);
        return cadastrado;
    }
}
