package com.helloworld.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yourName = request.getParameter("yourName");
		String password = request.getParameter("password");
		String friendName = request.getParameter("Fname");
		
		PrintWriter writer = response.getWriter();
		writer.println("<body style='text-align:center;background:lightgrey'><h4>Hello " + yourName +" liking all post on your facebook newsfeed"+ "</h4></body>");
		writer.close();
    	 System.setProperty("webdriver.chrome.driver",
                 "C:\\Users\\agoswmai\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	 ChromeOptions option = new ChromeOptions();
 		//option.addArguments("disable-geolocation");
 		option.addArguments("disable-notifications");
 		WebDriver driver = new ChromeDriver(option);
 		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 		//WebDriverWait wait = new WebDriverWait(driver, 3000);
 		driver.manage().window().maximize();
 		String googleUrl = "http://www.fb.com/";
 		driver.get(googleUrl);
 		driver.findElement(By.name("email")).sendKeys(yourName);
 	    driver.findElement(By.name("pass")).sendKeys(password+Keys.ENTER);
 		//driver.findElement(By.xpath("//div[@class='_cy7']")).click();
 		driver.findElement(By.xpath("//input[@class='_1frb']")).sendKeys(friendName+Keys.ENTER);
        //List<WebElement>sl=driver.findElements(By.xpath("//*[@class='_19bk']"));
        // sl.get(0).click();
 		 List<WebElement>nl=driver.findElements(By.xpath("//a[@data-ft='{\"tn\":\"-]\"}']"));
         nl.get(0).click();
         String c=driver.getCurrentUrl();
         driver.get(c);
         JavascriptExecutor js=(JavascriptExecutor)driver;
         try {
 			Thread.sleep(1100);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		js.executeScript("window.scrollBy(0,4000)", "");
 		//js.executeScript("window.scrollBy(0,4000)", "");
 	    List<WebElement> like = driver.findElements(By.xpath("//div[@class='_666k']//div[@class='_8c74']"));
 	    System.out.println(like.size());
 	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    System.out.println(like.get(0).getText());
 	    System.out.println(like.get(1).getText());
 	    for(int i=0;i<like.size();i++){
 	    	//if(like.get(i).getAttribute("aria_pressed")!="true")
 	    	
 	    	like.get(i).click();
 	    	System.out.print(i);
 	    }
	}

}
