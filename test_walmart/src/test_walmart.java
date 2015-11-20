import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test_walmart {
	
	public static void main(String [] args) {		
			
		//shop.addItemToCart(searchWords);
		test_walmart test = new test_walmart();
		//test.addItemToCart(searchWords);
		try {
			test.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void setUp() throws Exception
	{	//Opens the chrome driver
		String PATH_TO_DRIVER = "C:\\Users\\VETRI\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);	
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		addItemToCart(driver);
	}
	@DataProvider(name = "Declare a list of keywords to be searched")
	public ArrayList<String> searchWords()
	{	//storing the items to be searched in an arraylist
		ArrayList<String> searchWords = new ArrayList<String>();
		searchWords.add("toys");
		searchWords.add("tv");
		searchWords.add("socks");
		searchWords.add("dvd");
		searchWords.add("iPhone");
		return searchWords;
	}
	@Test(description = "sign in, search, add to cart and validate", dataProvider = "Declare a list of keywords to be searched")
	public void addItemToCart(WebDriver driver) {
		ArrayList<String>searchWords = searchWords();
		shoppingCart shop = new shoppingCart();
		/**Enter your credentials and login to walmart website**/
		shop.walmartlogin(searchWords);
		System.out.println("back to main");
		/**Search each item in the Search box**/ 
		shop.searchAndAddToTheCart(searchWords);
	}	
}