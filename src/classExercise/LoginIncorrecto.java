package classExercise;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import java.time.Instant;

public class LoginIncorrecto  {
    //Declaro mis variables para trabajar con el webDriver y con los waits
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        // esta es la clase principal que mandará llamar a los métodos con sus parámetros y valores específicos
        // para cada parámetro
        navegarUrl("https://evening-bastion-49392.herokuapp.com/");
        verificarHomePage();
        loginIncorrecto("frenk", "sinotra"); //variable badUser y badPass con su valor
        verificarMensajeError("The username or password you entered are incorrect"); //mensaje que será el verificador

    }


    private static void navegarUrl(String url) {
        driver= new ChromeDriver(); //abro una ventana de Chrome o un navegador
        driver.get(url); //obtengo el valor de la URL
        wait = new WebDriverWait(driver, 15); //el wait para esperar a que aparezca el elemento
    }


    private static void verificarHomePage() {
        //Wait para esperar que aparezca la imagen de Frank Sinatra para validar que estamos en el Home Page
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[alt='Frank Sinatra']")));
        //Wait para esperar que aparezca el link de "Log in" y declaro la variable "loginLink" de tipo WebElement
        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href='/login']")));
        loginLink.click();
    }


    private static void loginIncorrecto(String badUser, String badPass) {
        //Declaro la variable "UserName" de tipo "WebElement" con su respectivo wait para que aparezca el elemento
        WebElement UserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        //Declaro la variable "UserName" con el método sendKeys para teclear el valor que hay
        //en la variable "badUser"; ese valor está dado de alta en la clase principal y será "frenk"
        UserName.sendKeys(badUser);

        //Declaro la variable "Password" de tipo "WebElement" con su respectivo wait para que aparezca el elemento
        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        //Declaro la variable "Password" con el método sendKeys para teclear el valor que hay
        //en la variable "badPass"; ese valor está dado de alta en la clase principal y será "sinotra"
        Password.sendKeys(badPass);

        //Declaro la variable "loginButton" de tipo "WebElement" con su respectivo wait para que aparezca el elemento
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='Log In']")));
        //Hago el evento "dar click" para el botón "loginButton"
        loginButton.click();
    }


    private static void verificarMensajeError(String errorMessage) {
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