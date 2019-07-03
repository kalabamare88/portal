import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.safari.SafariDriver;
import org.seleniumhq.jetty9.io.ssl.ALPNProcessor;

import javax.swing.text.Document;
import java.awt.*;
import java.io.*;
import java.util.List;


public class portal {

    public static void main(String[] args) throws InterruptedException, IOException {

        File gecko = new File("G:\\seleniumLab\\chromedriver.exe");
        System.setProperty("driver.chrome.driver", gecko.getAbsolutePath());
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(300,10));

        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.get("https://portal.aait.edu.et/");


        driver.findElement(By.name("UserName")).sendKeys("ATR/0078/09");

        Thread.sleep(1000);

        driver.findElement(By.name("Password")).sendKeys("password");

        Thread.sleep(1000);

        driver.findElement(By.className("btn-success")).click();

       Thread.sleep(5000);

        driver.findElement(By.id("ml2")).click();


        Thread.sleep(6000);


      //
        List<WebElement> grade = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div"));
        System.out.println(grade.size() + " Grade Roports are printed here ");
        var fileWriter=new FileWriter("UnreadNewMessages.txt");

        for (WebElement message: grade ) {
            System.out.println(message.getText());

            fileWriter.write(message.getText()+"\n");
        }
        fileWriter.close();


        driver.quit();




        //

        //



    }
}










