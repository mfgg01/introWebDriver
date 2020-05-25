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
        buscarCelebridad("Simon Baker");
        //      verificarResultados (verificaResult: "Simon Baker (I)");
        //     buscarTrailer();
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


    private static void buscarCelebridad(String textoBuscar) {
        //Declaro la variable "categoria" con su respectivo wait
        //WebElement categoria= wait.until(ExpectedConditions.visibilityOfElementsLocated(By.cssSelector([class="ipc-button__text"]));

        //Declaro la variable "textBox" con su respectivo wait
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search")));
        textBox.sendKeys(textoBuscar);

        //Declaro la variable "searchButton" con su respectivo wait
        WebElement searchButton = driver.findElement(By.className("nav-search__search-submit _2wo2z_hfPCHWGjZvUGi_f1"));
        searchButton.click();
    }
}

    /*private static void verificarResultados(    ) {
        //Declaro la variable "loggedInMessage" de tipo "WebElement" con su respectivo wait para que aparezca el elemento
        WebElement loggedInMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".flash.notice")));

        //Esta es la verificación para saber si el caso de prueba pasó o falló
        //Si el texto de verificación es igual al texto que guarda la variable "loggedInMessage"
        if  (loggedInMessage.getText().equals("The username or password you entered are incorrect"))
            System.out.println("Caso de Prueba ejecutado correctamente"); //si es igual, el caso de prueba está OK
        else
            System.out.println("Caso de Prueba FALLADO"); //si no está igual, el caso de prueba está FAIL

        driver.close(); //Para cerrar la ventana del navegador
    }
}

    private static void buscarTrailer(String errorMessage) {

    }
*/