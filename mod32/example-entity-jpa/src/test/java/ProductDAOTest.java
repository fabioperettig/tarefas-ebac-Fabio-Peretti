import com.fabioperettig.dao.IProductDAO;
import com.fabioperettig.dao.ProductDAO;
import com.fabioperettig.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductDAOTest {

    IProductDAO productDAO;
    Product product;

    public ProductDAOTest() {
        productDAO = new ProductDAO();
    }

    @BeforeEach
    public void setUp() {
        product = createProduct();
        Assertions.assertNotNull(product);
    }

    @Test
    public void createProductTest() {
        Product productDB = productDAO.readById(product.getId());
        Assertions.assertNotNull(productDB);
        Assertions.assertEquals(product.getId(), productDB.getId());
        Assertions.assertEquals(product.getName(), productDB.getName());
    }

    @Test
    public void readProductTest() {
        Product productDB = productDAO.readById(product.getId());
        Assertions.assertNotNull(productDB);
        Assertions.assertEquals(product.getId(), productDB.getId());
        Assertions.assertEquals(product.getName(), productDB.getName());
    }

    @Test
    public void updateProductTest() {
        Product productDB = productDAO.readById(product.getId());
        Assertions.assertNotNull(productDB);
        Assertions.assertEquals(product.getId(), productDB.getId());
        Assertions.assertEquals(product.getName(), productDB.getName());

        productDB.setName("PRODUTO TS1");
        Product productUp = productDAO.update(productDB);
        Assertions.assertEquals("PRODUTO TS1", productUp.getName());
    }

    @Test
    public void deleteProductTest() {
        productDAO.delete(product);
        Product productDel = productDAO.readById(product.getId());
        Assertions.assertNull(productDel);
    }

    public Product createProduct() {
        Product product = new Product();
        product.setCode("PROD001");
        product.setName("Produto TS01");
        product.setValue(299.00);

        product = productDAO.create(product);

        return product;
    }
}
