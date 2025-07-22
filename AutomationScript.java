package com.MakeMyTrip;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MakeMyTripAutomation {

	public static void main(String[] args) {
		
		//WebDriver wd = new ChromeDriver();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeOptions);
		
		wd.get("https://www.makemytrip.com/");
		
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		
		By closeModalLocator=By.xpath("//span[@data-cy=\"closeModal\"]");
		WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(closeModalLocator));
		
	 By forCityLabelLocator = By.xpath("//label[@for=\"fromCity\"]");
	 WebElement forCityLabel =wait.until(ExpectedConditions.visibilityOfElementLocated(forCityLabelLocator));
	 forCityLabel.click();
			 
	  By forCityInputTextBoxLocator= By.xpath("//input[@placeholder=\"From\"]");
	WebElement forCityInputTextBox =wait.until(ExpectedConditions.visibilityOfElementLocated(forCityInputTextBoxLocator));
	forCityInputTextBox.sendKeys("Pune");
	
	
	By fromCitySuggestionListLocator = By.xpath("//p[conatins(text(),\"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");
	
	 boolean state = wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(fromCitySuggestionListLocator),
			 ExpectedConditions.numberOfElementsToBeLessThan(fromCitySuggestionListLocator, 12)));
	 
	 List<WebElement> forCitySuggestionList=null;
	 
	 if(state) {
		 forCitySuggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromCitySuggestionListLocator));
		 
	 }
	 System.out.println(forCitySuggestionList.size());
	 
			 
	for(WebElement suggestion:forCitySuggestionList) {
		System.out.println(suggestion.getText());
		
	}
			 
		forCitySuggestionList.get(0).click();	 //selecting first location from city
		
		
		
		//Populating TO location:
		
		By toCityLabelLocator= By.xpath("//label[@for=\"toCity\"]");
		WebElement toCityLabel= wait.until(ExpectedConditions.visibilityOfElementLocated(toCityLabelLocator));
		toCityLabel.click();
		
		By toCityInputTextBoxLocator = By.xpath("//input[@placeholder=\"To\"]");
		WebElement toCityTextBox= wait.until(ExpectedConditions.visibilityOfElementLocated(toCityLabelLocator));
		toCityTextBox.sendKeys("Hyderabad");
		
		By toSuggestionListLocator= By.xpath
				("//p[conatins(text(),\"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");
		
		state=wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(toSuggestionListLocator),
				 ExpectedConditions.numberOfElementsToBeMoreThan(toSuggestionListLocator, 10)));

		
		List<WebElement> toCitySuggestionList=null;
		
		if(state) {
			 toCitySuggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toSuggestionListLocator));
			 
		 }
		 System.out.println(toCitySuggestionList.size());
		 
				 
		for(WebElement suggestion:toCitySuggestionList) {
			System.out.println(suggestion.getText());
			
		}
				 
			toCitySuggestionList.get(0).click();	 //selecting first location from city
			
			
			
		//Introducing concept of locat date :
			
			
		
		LocalDate targetdate=LocalDate.now();
		targetdate=targetdate.plusMonths(1);
		String targetMonth=targetdate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);//july
		int targetYear=targetdate.getYear(); //2025
		int taregtDay=targetdate.getDayOfMonth();//21
		
		//System.out.println("//div[contains(text(),\"July 2025\")]/ancestor::div[@class=\"DayPicker-Month\"]");
		//("//div[contains(text(),\'\" + targetMonth + \" \" + targetYear + \"' )]/ancestor::div[@class=\"DayPicker-Month\"]");
		
		
		By calenderMonthLocator =By.xpath("//div[contains(text(),\'\" + targetMonth + \" \" + targetYear + \"' )]/ancestor::div[@class=\"DayPicker-Month\"]");
        WebElement calenderMonth=wait.until(ExpectedConditions.visibilityOfElementLocated(calenderMonthLocator));
        
        By dateLocator =By.xpath(".//p[text()='" + taregtDay+ "' ]/ancestor::div[contains(@class,\"DayPicker-Day\")]");
			
			
		WebElement date = calenderMonth.findElement(dateLocator);
		date.click();




			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		
		

	}

}
