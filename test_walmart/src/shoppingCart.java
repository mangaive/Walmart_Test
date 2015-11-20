 import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class shoppingCart {
	private final String PATH_TO_DRIVER = "H:\\chromedriver.exe";
	private final String LOGIN_BTN_XPATH = "/html/body/div[2]/section/section[4]/div/div/div/div/div/div/div/form/div/button";
	private final String WALMART_ACCOUNT = "http://www.walmart.com/account";
	private final String LOGIN_USERNAME = "walmarttest132@gmail.com";
	private final String LOGIN_PASSWORD = "shopping";
	private final String SEARCH_BTN_XPATH = "/html/body/div[2]/header/div[3]/div/div/div/div/div[3]/form/div/div[2]/span/input";
	private final String LINK_TOYS = "http://www.walmart.com/search/?query=toys&redirect=false";
	private final String PRODUCT_TITLE = "a[class=js-product-title]";
	private final String ADD_TO_CART = "WMItemAddToCartBtn";
	private final String PAC_ITEM_LINK = "PACSubTtlItemLnk";
	private final String CONT_SHOP_BTN = "PACContShopBtn";
	//public WebElementHelper _elemHelper;
	//private final 
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	
		public void walmartlogin(ArrayList<String> searchwords )
		{
			System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);		 
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
			 
			driver.get(WALMART_ACCOUNT);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    
		    //finding login elements
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    WebElement id = driver.findElement(By.id("login-username"));
		    WebElement pass = driver.findElement(By.id("login-password"));
		    //logging url
		    WebElement button = driver.findElement(By.xpath(LOGIN_BTN_XPATH));
		    Assert.assertTrue(id != null);
		    Assert.assertTrue(pass != null);
		    
		    if(id != null)
		    {		    	
		    	id.clear();
		    	id.sendKeys(LOGIN_USERNAME);
		    }
		    if(pass!=null)
		    	pass.sendKeys(LOGIN_PASSWORD);
		    System.out.println("button clicked");
		    button.click();	
		}
		
		public void searchAndAddToTheCart(ArrayList<String> searchWords)
		{
			Assert.assertEquals(5, searchWords.size());
			for(int i=0 ; i < searchWords.size() ; i++)
		    { 	
				//looking for searchbox on the webpage
				driver.findElement(By.xpath(SEARCH_BTN_XPATH));
				driver.navigate().refresh();
		   //if(searchWords.get(index))
			 //  http://www.walmart.com/search/?query=toys&redirect=false
		   //Entering the key searchwords into the searchbox and clicking enter
				if(searchWords.get(i).equals("toys"))
					driver.get(LINK_TOYS);
				driver.findElement(By.xpath(SEARCH_BTN_XPATH)).sendKeys(searchWords.get(i));
				driver.findElement(By.xpath(SEARCH_BTN_XPATH)).sendKeys(Keys.ENTER);
				driver.switchTo().defaultContent();				
				selectAddValidate();
				//validateNoOfItems(allSearchItems);
				//continue shopping
			      WebElement contShop = driver.findElement(By.id(CONT_SHOP_BTN));
			      Assert.assertTrue(contShop != null);
			      contShop.click();
			  }
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
			driver.quit();
		}
		
		public void selectAddValidate() 
		{     //selects an item from the search results, add it to cart, check if item is the only one in cart
			List<WebElement> allSearchResults=driver.findElements(By.cssSelector(PRODUCT_TITLE));
			   System.out.println(allSearchResults.size());
			   driver.navigate().refresh();
			   //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   
			   allSearchResults=driver.findElements(By.cssSelector(PRODUCT_TITLE));
			   allSearchResults=driver.findElements(By.cssSelector(PRODUCT_TITLE));			   
			   
			   for(WebElement eachResult : allSearchResults) {				  
				   System.out.println("Title : "+eachResult.getText()+", Link : "+eachResult.getAttribute("class"));
				   }
			   //
			   System.out.println(allSearchResults.size());
			   System.out.println("Item going to be added to cart is :");
			   System.out.println(allSearchResults.get(1).getText()); // this is the item to be added to cart
			 //item added to cart is stored in a string to be compared later(for validation)	   
			   
			   String result1 = allSearchResults.get(1).getText();		
			   WebElement cartItemElement = allSearchResults.get(1);
			   driver.get(allSearchResults.get(1).getAttribute("href"));
			   Assert.assertTrue(cartItemElement != null);
			   			   
			  //WebElement addTocart
			   
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 //wait for a while , to give user a chance to choose colour in case option for color appears
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);			  
			  action.moveToElement(driver.findElement(By.id(ADD_TO_CART))).click().perform();
			  WebElement checkItem = driver.findElement(By.id(PAC_ITEM_LINK));
			  Assert.assertTrue(checkItem != null);
			  System.out.println(checkItem.getText());
			  String validateItem ="(1 item)";			  
			      
				  if(!(validateItem.equalsIgnoreCase(checkItem.getText())))
			      {		    	  
			    	  System.out.println("There is more than 1 item in cart");	    	  
			      }
			     // boolean present;
			      String SubString_result2 = result1.substring(0, 10);
					
			      if(driver.getPageSource().contains(SubString_result2)) {
		              System.out.println("Item is in Cart" );		              
		          }
		          else  {
		                 System.out.println("Item not in cart");		                
		          }			
		 }		
}