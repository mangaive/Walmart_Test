INSTALLATIONS REQUIRED:
• Java 7 or higher
• Eclipse
• Selenium WebDriver(All the Selenium jar files have been included in the project folder under the selenium folder)
• Chrome WebDriver

PROJECT SETUP INSTRUCTIONS:
• Create a new project in Eclipse and add Selenium jar files to it
• Change the current chromedriver path to the path where ChromeDriver is saved on your system 

ASSIGNMENT:
• Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome or Safari browser.
Scenario to automate:
• Login using existing account
• Perform a search on home page from a pool of key words given below
• Identify an item from the result set that you can add to cart
• Add the item to cart
• Validate that item added is present in the cart and is the only item in the cart

TEST DATA:
• Account details: 
  Username: walmarttest132@gmail.com 
  Password:shopping
• Search terms: tv, socks, dvd, toys, iPhone

ASSUMPTIONS:
• We assume that cart is initially empty
• All selected items are added in default conditions
• For any pop-ups that appear,user has to close it manually.
• If the test is to be run more than once, make sure that the cart is empty before the run i.e. manually empty the cart before each run.
• If any item requires an option to be choosen (eg.colour of item), the user has to choose it manually.

TEST FLOW:
• Chrome Opens
• Login happens on Walmart site
• Using a list of keywords, each item is searched one by one
• Each item is searched and from result set one item is selected and added to cart  
• Add item to cart 
• Validate that item added is present in the cart and if it's the only one item in the cart

MISSING:
• If any item requires an option to be choosen (eg.colour of item) user has to choose it manually or else test will fail.
• Any pop-ups appearing while this process happens should be handled manually by the user.
• When all items have been added to the cart, user has to manually remove all the items before running another test.

WHY MISSING:
• Time Constraint

POSSIBLE BUGS:
• Search may fail sometimes if format of page is different from the tested one.

IMPROVEMENTS:
• More test cases can be written to improve the maintainability of the code
• Can try to make it more genric to handle more elements and variety of cases.
• Automate more test cases to make it more robust.
• Cases can be handled where, more specifications are provided by the user and an appropriate product is chosen as per the specifications.

CODE REUSABILITY: 
• The code implemented is generic and can be reused. If more test cases need to be added, we can just make a separate method for that.	