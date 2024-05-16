import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Настройване на опции за ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Активиране на Headless режим

        // Създаване на инстанция на WebDriver с опциите
        WebDriver driver = new ChromeDriver(options);

        // Отваряне на уеб страницата
        driver.get("https://fxverify.com/chart?s=XAU.USD&gad_source=1&gclid=CjwKCAjwi_exBhA8EiwA_kU1Mut_H3ZsNT8K2gZyvFaArjTf3cqg_XDjZ2fj8mFClUMw1RiSFU0a5BoCVXIQAvD_BwE"); //Example 001
        //driver.get("https://www.xe.com/currencyconverter/convert/?Amount=1&From=XAU&To=BGN"); //Example 002

        /*// Изчакване за появата на елемента с клас "price-up" с максимално време 10 секунди
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); //za example 001 da e 5 sec
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.price-up"))); //Example 001
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.sc-1c293993-1.fxoXHw"))); //Example 002

        // Извличане на текста на елемента
        String value = element.getText();
        //double valueToDouble = Double.parseDouble(value) * 1.81;//Example 002

        // Отпечатване на стойността
        System.out.println("Стойността на елемента е: " + value);

        // Затваряне на браузъра
        driver.quit();*/
        String tempValue = "";

        while (true) {
            try {
                // Изчакване за появата на елемента с клас "sc-1c293993-1 fxoXHw" с максимално време 10 секунди
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.price-up")));

                // Извличане на текста на елемента
                String value = element.getText();

                if (!tempValue.equals(value)) {
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    // Създаване на формат за изход
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    // Форматиране на датата и времето и печатане на резултата
                    String formattedDateTime = currentDateTime.format(formatter);
                    System.out.println("Стойността на елемента е: " + value + " " + formattedDateTime);

                    tempValue = value;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
