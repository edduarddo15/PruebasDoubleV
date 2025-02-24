package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase creada para recuperar la contraseña
 */
public class RecuperarContrasenaPage extends Base {

    public WebDriver driver;

    private By txtCorreo = By.id("input-email");
    private By btnContinuar = By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input");

    public RecuperarContrasenaPage() {

    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public RecuperarContrasenaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Metodo utilizado para enviar el correo para recuperar la contraseña
     *
     * @param correo
     * @param driver
     * @author Eduardo Silva
     */
    public void recuperarContrasena(String correo, WebDriver driver) {
        setDriver(driver);
        type(correo, txtCorreo);
        clic(btnContinuar);
    }


}
