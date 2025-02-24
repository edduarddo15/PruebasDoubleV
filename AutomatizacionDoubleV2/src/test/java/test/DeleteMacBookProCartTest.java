package test;

import main.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.IndexPage;
import page.InicioPage;
import page.InicioSesionPage;


public class DeleteMacBookProCartTest {

    public WebDriver driver;
    public IndexPage indexPage;
    public InicioPage inicioPage;

    /**
     * Método ejecutado antes de iniciar el test para abrir navegador
     */

    @Before
    public void iniciar() {
        driver = Base.chromeDriverConnection();
        indexPage = new IndexPage(driver);
        inicioPage = new InicioPage(driver);

    }

    /**
     * Método que ejecuta el test
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        InicioSesionPage inicioSesion = indexPage.inicioSesion();
        InicioPage inicio = inicioSesion.iniciarSesion(
                "correo@hotmail.com",
                "123456*",
                driver);
        inicio.showAll(driver);
        inicio.addMacBookPro();
        inicio.deleteMacBookPro();

    }

    /**
     * Método ejecutado al finalizar el test para cerrar el navegador
     */
    @After
    public void cerrar() {
        driver.quit();
    }

}


