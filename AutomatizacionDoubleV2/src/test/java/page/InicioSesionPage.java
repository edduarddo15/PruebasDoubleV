package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Clase creada para iniciar sesion
 */
public class InicioSesionPage extends Base {

    public WebDriver driver;
    public RecuperarContrasenaPage contrasenaPage;
    public InicioPage inicioPage;

    // Elementos
    private By txtCorreo = By.id("input-email");
    private By txtContrasena = By.id("input-password");
    private By btnAcceso = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input");
    private By lnkOlvidoContrasena = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[2]/a");
    private By msnConfirmacion = By.xpath("/html/body/div[2]/div[1]");

    public InicioSesionPage() {

    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public InicioSesionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        inicioPage = new InicioPage(driver);
        contrasenaPage = new RecuperarContrasenaPage(driver);
    }

    /**
     * Método para iniciar sesion
     *
     * @param correo
     * @param contrasena
     * @param driver
     * @author Eduardo Silva
     */
    public InicioPage iniciarSesion(String correo, String contrasena, WebDriver driver) {
        setDriver(driver);
        type(correo, txtCorreo);
        type(contrasena, txtContrasena);
        clic(btnAcceso);
        return inicioPage;
    }

    /**
     * Método para dar clic en el link de contraseña olvidada
     *
     * @author Eduardo Silva
     */
    public RecuperarContrasenaPage recordarContrasena() {
        clic(lnkOlvidoContrasena);
        return contrasenaPage;
    }

    /**
     * Método creado para validar mensaje de envio de correo para recuperar contraseña
     *
     * @param message String
     * @throws InterruptedException
     * @author Eduardo
     */
    public void msndeConfirmacion(String message) throws InterruptedException {
        Assert.assertEquals(message, getText(msnConfirmacion));
        Thread.sleep(2000);
    }
}
