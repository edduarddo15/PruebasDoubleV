package test;

import main.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.IndexPage;
import page.RegistroPage;

/***
 * Clase creada para ejecuatr el test de registrar un usuario
 */
public class RegistroUsuarioTest {

    public WebDriver driver;
    public IndexPage indexPage;

    /**
     * Método ejecutado para abrir navegador
     *
     */
    @Before
    public void iniciar() {
        driver = Base.chromeDriverConnection();
        indexPage = new IndexPage(driver);
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
                "correo006@hotmail.com",
                "6448866",
                driver);
        registro.diligenciarContrasena(
                "123456*",
                "123456*");
        registro.aceptarPoliticasPrivacidad();
        registro.ingresarMiTienda();
    }

    /**
     * Metodo ejecutado al finalizar el test para cerrar el navegador
     *
     */
    @After
    public void cerrar() {
        driver.quit();
    }
}


