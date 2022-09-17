package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
			// clica no btn "Add Todo"
			driver.findElement(By.id("addTodo")).click();
			
			// escrevendo a descrição
			driver.findElement(By.id("task")).sendKeys("Task criada no teste funcional");
			
			// escrevendo data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2025");
			
			// clica no btn "Add Todo"
			driver.findElement(By.id("saveButton")).click();
			
			// verificando mensagem
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);			
		} finally {
			// fechando o browser
			driver.quit();		
		}
	}

	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
			// clica no btn "Add Todo"
			driver.findElement(By.id("addTodo")).click();
			
			// escrevendo a descrição
			//driver.findElement(By.id("task")).sendKeys("Task criada no teste funcional");
			
			// escrevendo data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2025");
			
			// clica no btn "Add Todo"
			driver.findElement(By.id("saveButton")).click();
			
			// verificando mensagem
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);			
		} finally {
			// fechando o browser
			driver.quit();		
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
			// clica no btn "Add Todo"
			driver.findElement(By.id("addTodo")).click();
			
			// escrevendo a descrição
			driver.findElement(By.id("task")).sendKeys("Task criada no teste funcional");
			
			// escrevendo data
			//driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			
			// clica no btn "Add Todo"
			driver.findElement(By.id("saveButton")).click();
			
			// verificando mensagem
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);			
		} finally {
			// fechando o browser
			driver.quit();		
		}
	}	

	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
			// clica no btn "Add Todo"
			driver.findElement(By.id("addTodo")).click();
			
			// escrevendo a descrição
			driver.findElement(By.id("task")).sendKeys("Task criada no teste funcional");
			
			// escrevendo data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			
			// clica no btn "Add Todo"
			driver.findElement(By.id("saveButton")).click();
			
			// verificando mensagem
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);			
		} finally {
			// fechando o browser
			driver.quit();		
		}
	}
	
	
}
