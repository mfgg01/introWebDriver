package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuscarLaptop {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
        driver.get("https://amazon.com.mx");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = driver.findElement(By.className("nav-input"));

        searchBox.clear();
        searchBox.sendKeys("Laptop HP");

        searchButton.click();
        WebElement seleniumLink = driver.findElement(By.partialLinkText("HP"));
        seleniumLink.click();

        ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Number of windows: " + windowIds.size());

        for(String windowId: driver.getWindowHandles()) {
            driver.switchTo().window(windowId);
        }

        // Buscar el precio en la lista de resultados
        WebElement precios = driver.findElement(By.className("a-price-whole"));

        //Declaramos un arreglo de precios
        List<WebElement> listaPrecios = driver.findElements(By.className("a-price-whole"));
        //Imprimimos los precios encontrados en consola
        System.out.println("Lista de Precios: " + listaPrecios.size());

        driver.close();
    }
}
