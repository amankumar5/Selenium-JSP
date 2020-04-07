package com.helloworld.javaee;

import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Servlet implementation class wekipidea
 */
@WebServlet("/wekipidea")
public class wekipidea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wekipidea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("searchText");
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\agoswmai\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        //option.addArguments("disable-geolocation");
        option.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(option);
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        driver.manage().window().maximize();
        String googleUrl = "http://www.wikipedia.org/";
        driver.get(googleUrl);
        driver.findElement(By.id("searchInput")).sendKeys(search+Keys.ENTER);
        
	}

}
