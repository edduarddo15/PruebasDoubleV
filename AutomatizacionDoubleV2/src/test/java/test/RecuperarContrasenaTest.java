package test;

import main.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.IndexPage;
import page.InicioSesionPage;
import page.RecuperarContrasenaPage;


public class RecuperarContrasenaTest {

    private WebDriver driver;
    private IndexPage indexPage;
    public RecuperarContrasenaPage contrasenaPage;

    /**
     * Método ejecutado antes de iniciar el test para abrir navegador
     */

    @Before
    public void iniciar() {
        driver = Base.chromeDriverConnection();
        indexPage = new IndexPage(driver);
        contrasenaPage = new RecuperarContrasenaPage(driver);

    }

    /**
     * Método que ejecuta el test
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        InicioSesionPage inicioSesion = indexPage.inicioSesion();
        RecuperarContrasenaPage contrasenaPage = inicioSesion.recordarContrasena();
        contrasenaPage.recuperarContrasena(
                "correo@hotmail.com",
                driver);
        inicioSesion.msndeConfirmacion("An email with a confirmation link has been sent your email address.");
    }

    /**
     * Método ejecutado al finalizar el test para cerrar el navegador
     */
    @After
    public void cerrar() {
        driver.quit();
    }
}


