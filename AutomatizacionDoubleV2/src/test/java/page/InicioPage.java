package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Clase creada para cargar la pantalla de inicio
 */
public class InicioPage extends Base {

    public WebDriver driver;
    public RecuperarContrasenaPage contrasenaPage;
    public CheckoutPage checkoutPage;

    //Elementos
    private By mnuLaptops = By.xpath("/html/body/div[1]/nav/div[2]/ul/li[2]/a");
    private By optShowAll = By.xpath("/html/body/div[1]/nav/div[2]/ul/li[2]/div/a");
    private By mnuMyAccount = By.xpath("/html/body/div[2]/div/aside/div/a[1]");
    private By lblCategoriaLaptops = By.xpath("/html/body/div[2]/div/div/h2");
    private By btnAddMacBookPro = By.xpath("/html/body/div[2]/div/div/div[4]/div[4]/div/div[2]/div[2]/button[1]");
    private By btnAddSamsungGalaxyTab = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button[1]");
    private By txtSearch = By.xpath("/html/body/header/div/div/div[2]/div/input");
    private By btnSearch = By.xpath("/html/body/header/div/div/div[2]/div/span/button");
    private By btnCart = By.xpath("/html/body/header/div/div/div[3]/div/button");
    private By btnRemove = By.xpath("/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody/tr/td[5]/button");
    private By btnCheckout = By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[2]");

    public InicioPage() {

    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public InicioPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        contrasenaPage = new RecuperarContrasenaPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    /**
     * Método para ingresar a la categoria de laptops
     *
     * @param driver
     * @author Eduardo Silva
     */
    public void showAll(WebDriver driver) {
        setDriver(driver);
        clic(mnuLaptops);
        clic(optShowAll);
    }

    /**
     * Método para adicionar un macbook
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void addMacBookPro() throws InterruptedException {
        clic(btnAddMacBookPro);
        Thread.sleep(2000);
    }

    /**
     * Método para buscar un producto
     *
     * @param buscar
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void buscarProducto(String buscar) throws InterruptedException {
        type(buscar, txtSearch);
        clic(btnSearch);
        Thread.sleep(2000);
    }

    /**
     * Método para adicioanr una tablet samsung
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void addSamsungGalaxyTab() throws InterruptedException {
        clic(btnAddSamsungGalaxyTab);
        Thread.sleep(2000);
    }

    /**
     * Método para eliminar un articulo del carrito de compras
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void deleteMacBookPro() throws InterruptedException {
        clic(btnCart);
        clic(btnRemove);
        Thread.sleep(2000);
    }

    /**
     * Metodo para iniciar el proceso de pago de una orden
     *
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public CheckoutPage pagarOrden() throws InterruptedException {
        clic(btnCart);
        clic(btnCheckout);
        Thread.sleep(2000);
        return checkoutPage;
    }


    /**
     * Método creado para validar un menú específico en una página
     *
     * @param message String
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void verificarMenu(String message) throws InterruptedException {
        Assert.assertEquals(message, getText(mnuMyAccount));
        Thread.sleep(2000);
    }

    /**
     * Método creado para validar la categoría de una página cargada
     *
     * @param message String
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void verificarCategoria(String message) throws InterruptedException {
        Assert.assertEquals(message, getText(lblCategoriaLaptops));
        Thread.sleep(2000);
    }

    /**
     * Método creado para validar la addición de un elemento al carrito
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void validarAdicionCarrito(String inicio, String producto, String carrito) throws InterruptedException {

        // Encontrar el elemento div que contiene el mensaje
        WebElement alertDiv = driver.findElement(By.className("alert-success"));
        // Obtener el texto completo del div
        String mensajeCompleto = alertDiv.getText();

        // Verificar que el texto inicial está presente
        Assert.assertTrue(mensajeCompleto.contains(inicio), "El texto inicial no está presente.");
        // Verificar que el nombre del producto está presente
        Assert.assertTrue(mensajeCompleto.contains(producto), "El nombre del producto no está presente.");
        // Verificar que el texto del carrito está presente
        Assert.assertTrue(mensajeCompleto.contains(carrito), "El texto del carrito no está presente.");

        Thread.sleep(2000);
    }
}
