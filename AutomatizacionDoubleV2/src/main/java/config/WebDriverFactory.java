package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        WebDriver driver;
        switch (browserType){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                // Agrega el argumento --allowed-ips
                options.addArguments("--allowed-ips=<https://opencart.abstracta.us>");
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/firefox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser type not sopported: " + browserType);
        }
        return driver;
    }
}
