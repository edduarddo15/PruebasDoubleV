package page;

import main.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Base {

    public WebDriver driver;
    public InicioPage inicioPage;

    private By txtNombre = By.id("input-payment-firstname");
    private By txtApellido = By.id("input-payment-lastname");
    private By txtDireccion = By.id("input-payment-address-1");
    private By txtCiudad = By.id("input-payment-city");
    private By txtCodPostal = By.id("input-payment-postcode");
    private By lstPais = By.id("input-payment-country");
    private By lstEstado = By.id("input-payment-zone");
    private By btnContinuarS2 = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/div/input");
    private By btnContinuarS3 = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div/form/div[5]/div/input");

    public CheckoutPage() {

    }

    /**
     * Método constructor de la clase
     *
     * @param driver
     * @author Eduardo Silva
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        //inicioPage = new InicioPage(driver);
    }

    /**
     * Método para diligenciar los datos básicos en el procso de pagar la orden
     *
     * @param nombre
     * @param apellido
     * @param direccion
     * @param ciudad
     * @param codPostal
     * @param driver
     * @author Eduardo Silva
     */
    public void datosBasicos(String nombre, String apellido, String direccion, String ciudad, String codPostal, WebDriver driver) {
        setDriver(driver);
        type(nombre, txtNombre);
        type(apellido, txtApellido);
        type(direccion, txtDireccion);
        type(ciudad, txtCiudad);
        type(codPostal, txtCodPostal);
    }

    /**
     * Método crerado para seleccionar el país
     *
     * @param pais
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public String selectOptionListPais(String pais) throws InterruptedException {
        Select list = new Select(driver.findElement(lstPais));
        list.selectByVisibleText(pais);
        Thread.sleep(2000);
        return null;
    }

    /**
     * Método creado para selecionar el estado
     *
     * @param estado
     * @return
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public String selectOptionListEstado(String estado) throws InterruptedException {
        Select list = new Select(driver.findElement(lstEstado));
        list.selectByVisibleText(estado);
        Thread.sleep(2000);
        return null;
    }

    /**
     * Método creado para continuar con la sección 2 de la orden de pago
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void continuarS2() throws InterruptedException {
        clic(btnContinuarS2);
        Thread.sleep(2000);
    }

    /**
     * Método creado para continuar con la sección 2 de la orden de pago
     *
     * @throws InterruptedException
     * @author Eduardo Silva
     */
    public void continuarS3() throws InterruptedException {
        clic(btnContinuarS3);
        Thread.sleep(2000);
    }

}
