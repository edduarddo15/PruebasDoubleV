package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 * Clase creada para definir metodos generales para las pruebas
 */
public class Base {

    private WebDriver driver;

    /**
     * Método constructor
     *
     * @param driver WebDriver
     */
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public Base() {};

    /**
     * Método utilizado para abrir el navegador de Chrome
     *
     * @return
     * @author Eduardo
     */
    public static WebDriver chromeDriverConnection() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        // Configura las opciones de Chrome para ignorar errores de seguridad
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors"); // Ignora errores de certificado
        options.addArguments("--allow-insecure-localhost"); // Permitir localhost inseguro
        options.addArguments("--disable-web-security"); // Desactiva seguridad web (usado con precaución)

        // Crea una instancia de ChromeDriver con las opciones especificadas
        driver = new ChromeDriver(options);

        try {
            // Accede a la URL deseada
            driver.get("https://opencart.abstracta.us");

            // Mantén el navegador abierto para que puedas ver la página
            System.out.println("Accediendo a la URL: " + driver.getCurrentUrl());
            // Puedes agregar aquí otros comandos de Selenium para interactuar con la página

            // Espero indefinidamente (o puedes usar un método diferente para mantenerlo abierto)
            Thread.sleep(5000); // Espera 100 segundos (ajusta según sea necesario)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver;
    }

    /**
     * Metodo creado para escribir texto en un elemento
     *
     * @param inputText String
     * @param locator   By
     * @author Eduardo
     */
    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * Método creado para dar clic a el elemento
     *
     * @param locator By
     * @author Eduardo
     */
    public void clic(By locator) {
        driver.findElement(locator).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }





    /**
     * Método creado para devolver el valor del elemento
     *
     * @param locator
     * @return
     * @author Eduardo
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
