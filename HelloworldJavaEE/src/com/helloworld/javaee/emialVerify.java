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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Servlet implementation class emialVerify
 */
@WebServlet("/emialVerify")
public class emialVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emialVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("myEmail");
		String mypassword = request.getParameter("myPassword"); 
		PrintWriter writer = response.getWriter();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\agoswmai\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		//option.addArguments("disable-geolocation");
		option.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://gmail.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		email_phone.sendKeys(email);
		driver.findElement(By.id("identifierNext")).click();
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(mypassword);
		driver.findElement(By.id("passwordNext")).click();
		List<WebElement>read=driver.findElements(By.className("yO"));
		List<WebElement>unread=driver.findElements(By.className("zE"));
		List<WebElement>total_mails=driver.findElements(By.xpath("//div[@class='oZ-jc T-Jo J-J5-Ji ']"));
		
		writer.println("<body style='background:lightgrey'>");
		writer.println("<div style='text-align:left'><h3>Total mails are : "+total_mails.size()+"</h3> <br>");
		writer.println("<h3>Total read mails are : "+read.size()+"</h3> <br>");
		writer.println("<h3>Total unread mails are : "+unread.size()+"</h3></div> <br>");
		writer.println("<h3>Your unread mails</h3>");
		
		writer.println("<div style='text-align:center'>");
		writer.println("<textarea style='width:600px;height:450;background:whitesmoke'>");
		for(int i=0;i<unread.size();i++){
			writer.println(unread.get(i).getText()+"\n");
			writer.print("-------------------------------------------------------------------------------\n");
		}
		writer.println("</textarea></body>");
		writer.println("</div>");
		
		writer.close();
	}

}
