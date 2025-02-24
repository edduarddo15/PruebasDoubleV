package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase creada para cargar el index de la página
 */
public class IndexPage extends Base {

    public WebDriver driver;
    public InicioSesionPage inicioSesionPage;

    // Elementos
    private By icnMiCuenta = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/i");
    private By optRegistro = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a");
    private By optAcceso = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a");

    public IndexPage() {
    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public IndexPage(WebDriver driver) {
        setDriver(driver);
        inicioSesionPage = new InicioSesionPage(driver);
    }

    /**
     * Método creado para ingresar a crear un registro de un usuario
     *
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public RegistroPage crearRegistro() throws InterruptedException {
        clic(icnMiCuenta);
        clic(optRegistro);
        Thread.sleep(2000);
        return new RegistroPage(driver);
    }

    /**
     * Método creado para ingresar a la página principal
     *
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public InicioSesionPage inicioSesion() throws InterruptedException {
        clic(icnMiCuenta);
        clic(optAcceso);
        Thread.sleep(2000);
        return inicioSesionPage;
    }

}

