package com.helloworld.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        PrintWriter writer = response.getWriter();
        //option.addArguments("disable-geolocation");
        option.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(option);
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        driver.manage().window().maximize();
        String url="http://www.google.com/";
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys(search+Keys.ENTER);
        WebElement wiki=null;
        int flag=0;
        writer.println("<body style='background:lightgrey;text-align:center'>");
        
        List<WebElement> list = driver.findElements(By.className("TbwUpd"));
writer.println("<h1>Wikipedia : "+search+"</h1>");
		
		writer.println("<div style='text-align:center'>");
		writer.println("<textarea style='width:600px;height:450;background:whitesmoke'>");
		for(WebElement web:list){
			
			if(web.getText().contains("en.wikipedia.org")) 
			{
				web.click();
				WebElement text=driver.findElement(By.xpath("//*[@id=\"bodyContent\"]"));
				writer.println(text.getText());
				flag=1;
				break;
			}
			
		}
		if(flag==0) {
			writer.println("No wikipedia found!!!!");
        
	}
		writer.println("</textarea></div></body>");
		
	}
		

}
