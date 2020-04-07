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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Servlet implementation class hackerrank
 */
@WebServlet("/hackerrank")
public class hackerrank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hackerrank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		System.out.println(mail+password);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\agoswmai\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("input-1")).sendKeys(mail);
 	    driver.findElement(By.id("input-2")).sendKeys(password+Keys.ENTER);
 	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	  writer.println("<body style='text-align:center;background:lightgrey'><h4>Hello " +mail +" opening your hackerrank"+ "</h4></body>");
		writer.close();
 	   
		
		
	}

}
