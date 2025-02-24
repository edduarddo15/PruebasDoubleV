package test;

import main.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.*;


public class CheckoutTest {

    public WebDriver driver;
    public IndexPage indexPage;
    public InicioPage inicioPage;
    public CheckoutPage checkoutPage;

    /**
     * Método ejecutado antes de iniciar el test para abrir navegador
     */

    @Before
    public void iniciar() {
        driver = Base.chromeDriverConnection();
        indexPage = new IndexPage(driver);
        inicioPage = new InicioPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    /**
     * Método que ejecuta el test
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        RegistroPage registro = indexPage.crearRegistro();
        registro.diligenciarDatosPersonales(
                "Juan",
                "Cain",
                "correo001@hotmail.com",
                "6448866",
                driver);
        registro.diligenciarContrasena(
                "123456*",
                "123456*");
        registro.aceptarPoliticasPrivacidad();
        InicioPage inicio = registro.ingresarMiTienda();
        inicio.showAll(driver);
        inicio.addMacBookPro();
        CheckoutPage checkout = inicio.pagarOrden();
        checkout.datosBasicos(
                "Juan",
                "Cain",
                "Calle 100",
                "Bogota",
                "110111",
                driver);
        checkout.selectOptionListPais("Colombia");
        checkout.selectOptionListEstado("Cundinamarca");
        checkout.continuarS2();
        checkout.continuarS3();


    }

    /**
     * Método ejecutado al finalizar el test para cerrar el navegador
     */
    /*@After
    public void cerrar() {
        driver.quit();
    }
*/
}


