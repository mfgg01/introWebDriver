package classExercise;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import java.time.Instant;

public class BuscarTrailer {
    //Declaro mis variables para trabajar con el webDriver y con los waits
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        // esta es la clase principal que mandará llamar a los métodos con sus parámetros y valores específicos
        // para cada parámetro
        navegarUrl("https://www.imdb.com/");
        verificarHomePage();
        buscarCelebridad("Celebs", textoBuscar: "Simon Baker");
        verificarResultados();
        correrTrailer();
    }


    private static void navegarUrl(String url) {
        driver = new ChromeDriver(); //abro una ventana de Chrome o un navegador
        driver.get(url); //obtengo el valor de la URL
        wait = new WebDriverWait(driver, 15); //el wait para esperar a que aparezca el elemento
    }


    private static void verificarHomePage() {
        //Wait para esperar que aparezca la imagen del logo de IMDB para validar que estamos en el Home Page
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("home_img_holder")));
    }


    private static void buscarCelebridad(String dropSeleccion, String textoBuscar) {
        //Declaro la variable "categoria" con su respectivo wait
        WebElement categoria= wait.until(ExpectedConditions.visibilityOfElementsLocated(By.cssSelector("[class='ipc-button__text']")));
        categoria.sendKeys(dropSeleccion);

        //Declaro la variable "textBox" con su respectivo wait
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search")));
        textBox.sendKeys(textoBuscar);

        //Declaro la variable "searchButton" con su respectivo wait
        WebElement searchButton = driver.findElement(By.className("nav-search__search-submit _2wo2z_hfPCHWGjZvUGi_f1")));
        searchButton.click();
    }
}


    private static void verificarResultados() {
        WebElement resultLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.ByPartialLinkText("Simon Baker")));
        resultLink.click();
     }
}


    private static void correrTrailer() {
        WebElement imageLink = wait.until(ExpectedCondtions.presenceOfElementLocated(By.ccsSelector("[class='wtw-option']")));
        imageLink.click();
        WebElement playButton = wait.until(ExpectedCondtions.presenceOfElementLocated(By.cssSelector("[class='slate_button prevent-ad-overlay video-modal']")));
        playButton.click();
        driver.manage().timeouts().implicitlyWait(159,  TimeUnit.SECONDS);

        System.out.println("Nombre Trailer: " + nombreTrailer);
        System.out.println("Duración en minutos: " + minutos);
        System.out.println("Duración en segundos: " + segundos);

        driver.close();

    }
