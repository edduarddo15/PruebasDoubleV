package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase creada para registrar un usuario
 */
public class RegistroPage extends Base {

    public WebDriver driver;
    public InicioPage inicioPage;

    //Elementos de la clase
    private By txtNombre = By.id("input-firstname");
    private By txtApellido = By.id("input-lastname");
    private By txtCorreo = By.id("input-email");
    private By txtTelefono = By.id("input-telephone");
    private By txtContrasena = By.id("input-password");
    private By txtConfContrasena = By.id("input-confirm");
    private By chkTerminosCondiciones = By.xpath("/html/body/div[2]/div/div/form/div/div/input");
    private By btnContinuarReg = By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[2]/div/input");
    private By btnContinuar = By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]");

    public RegistroPage() {

    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public RegistroPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        inicioPage = new InicioPage(driver);
    }

    /**
     * Método utilizado para diligenciar los datos personales del formulario
     *
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param driver
     * @author Eduardo Silva
     */
    public void diligenciarDatosPersonales(String nombre, String apellido, String correo, String telefono, WebDriver driver) {
        setDriver(driver);
        type(nombre, txtNombre);
        type(apellido, txtApellido);
        type(correo, txtCorreo);
        type(telefono, txtTelefono);
    }

    /**
     * Método utilizado para diligenciar los campos de la contraseña
     *
     * @param contrasena
     * @param confConstrasena
     * @author Eduardo Silva
     */
    public void diligenciarContrasena(String contrasena, String confConstrasena) {
        type(contrasena, txtContrasena);
        type(confConstrasena, txtConfContrasena);
    }

    /**
     * Método utilizado para dar clic en en la opción de Politicas de privacidad
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void aceptarPoliticasPrivacidad() throws InterruptedException {
        clic(chkTerminosCondiciones);
        clic(btnContinuarReg);
        Thread.sleep(2000);
    }

    /**
     * Método utilizado para dar clic al botón que da el acceso a la tienda virtual del usuario registrado
     *
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public InicioPage ingresarMiTienda() throws InterruptedException {
        clic(btnContinuar);
        Thread.sleep(2000);
        return inicioPage;
    }
}
