package com.example.todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CompleteTaskTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/index.html");
    }

    @Test
    public void testCompleteTask() {
        WebElement taskInput = driver.findElement(By.id("taskInput"));
        WebElement addButton = driver.findElement(By.id("addTaskButton"));

        taskInput.sendKeys("Write Jenkinsfile");
        addButton.click();

        WebElement task = driver.findElement(By.xpath("//ul[@id='taskList']/li"));
        task.click();

        assertTrue(task.getAttribute("class").contains("completed"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
