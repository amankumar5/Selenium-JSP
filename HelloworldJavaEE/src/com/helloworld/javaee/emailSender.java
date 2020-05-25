package com.helloworld.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Servlet implementation class emailSender
 */
@WebServlet("/emailSender")
public class emailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emailSender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("myEmails");
		String mypassword = request.getParameter("myPasswords"); 
		String sub= request.getParameter("subject");
		String rId=request.getParameter("toId");
		String body=request.getParameter("body");
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
		WebElement composeBtn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji T-I-KE L3']"));
        composeBtn.click();
        WebElement toBox = driver.findElement(By.cssSelector("textarea[class='vO']"));
        toBox.sendKeys(rId);

        WebElement subjBox = driver.findElement(By.cssSelector("input[class='aoT']"));
        subjBox.sendKeys(sub);
        WebElement msgBox = driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf tS-tW']"));
        msgBox.sendKeys(body);
        WebElement sendBtn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']"));
        sendBtn.click();
        
        writer.println("<body style='text-align:center;background:lightgrey'><h4>"+" email has been sent "+"</h4></body>");
		writer.close();

       
	}

}
