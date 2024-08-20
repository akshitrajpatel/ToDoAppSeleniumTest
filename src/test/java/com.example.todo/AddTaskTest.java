package com.example.todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AddTaskTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/index.html");
    }

    @Test
    public void testAddTask() {
        WebElement taskInput = driver.findElement(By.id("taskInput"));
        WebElement addButton = driver.findElement(By.id("addTaskButton"));

        taskInput.sendKeys("Complete Selenium tutorial");
        addButton.click();

        WebElement task = driver.findElement(By.xpath("//ul[@id='taskList']/li"));
        assertEquals("Complete Selenium tutorial", task.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
