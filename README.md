
C.  Customize the HTML user interface for your customers application. The user interface should include the shop name, the product names and the names of the parts.
    
    File Name: mainscreen.html
    Line Number where changes were made: 14, 20, 26,and 58.
    Change: Title was changed to JC's Auto. Header(shop name) was changed to JC's Auto Parts. Parts changed to Car Parts. Products changed to Kits.

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
    
    File Name: mainscreen.html   &  About.html  & AboutController
    Line Number where changes were made: 
        On mainscreen.html: 21
        On About.html: 1 - 50
        On AboutController:  1-17 
    Changes on mainscreen.html: I added some styling and linked the About page to the navbar.
    Changes on About.html: Title changed to About JC's. Header changed to About JC's Auto. A Navbar was added and link was added to go back to the mainscreen.
                           Information was added to the h3 and h5 headers about JC's auto. Paragraphs were added about the history and a quote from JC.
    Changes on AboutController: Added a controller for the About page to create mapping to get a http request to view the about page.

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    
    File Name: BootStrapData.java & application.properties
    Line Number where changes were made:
        On BootStrapData.java: 45 - 102
        On application.properties: 6
    Changes made on application.properties: Changed the name of the database url so that a new database is retrieved from the model, with the data of the inventory that was created in the BootStrapData class.
    Chaneges made to BootStrapData.java: At line 45 and 94, an if statement was created to prevent the inventory from duplicating itself everytime it was uploaded.
                                        The Inventory will only load up again once all the sample parts or products reach 0.
                                        Lines 47 - 90 use the set methods from the outsource part object extended from the part class, to add part information for the sample inventory.
                                        Lines 96 - 119 use the product contructor to initialize new product objects. 

F. Add a "Buy Now" button to our product list. Your "Buy Now" button must meet each of the following parameters:
- The "The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.

    
    File Name: mainscreen.html, ProductService, ProductServiceImpl, BuyProductController, buySuccess.html & outofstock.html
    Line Number where changes were made:
        On mainscreen.html: 91
        On ProductService: 22
        On ProductServiceImpl: 71 - 74
        On BuyProductController: 1 - 43
        On buySuccess.html: 1 - 49
        On outofstock.html: 1 - 39
    Changes made on mainscreen: added a "Buy Now" button and used a thymeleaf expression to generate a URl that will depend on the product ID.
    Changes made in ProductService file: Initialized a boolean decrementInv method.
    Changes made in ProductServiceImpl file: Defined the decrementInv method that passes a product as a parameter and checks if it exists and if the inventory is greater than 0, returning true or false. 
    Changes made in the BuyProductController file: developed a controller named BuyProductController, set up injections of ProductRepository and ProductServiceImpl and set up a @GetMapping for "/buyProduct". 
            I also set up a constructor injections of the BuyProductController. In this file I also defined the buyProduct method that accepts a productID as a parameter, that's mapped to theId and a model object.
            After fetching the productID within the method, there is an if statement that brings in the decrementInv() method, which checks to see if the product can be decremented. If the statement returns true, 
            then the product inventroy is decremented by one. and the model attribute is set to the name of the product, which is then referenced in the thymeleaf template in the buySuccess page.
            If the statemet returns false, then the prodcut name is still added to the model as an attribute, but it is not decremented, and will be displayed in the outofstock page.
    Changes made in the buySuccess AND the outofstock files: The buySuccess template was created to display a confirmation page to the customer, letting them know they successfully bought a product. The outofstock template
            was created to display a message to the customer to let them know that the product is out of stock. the thymeleaf expressions in both, pull information from the model in the BuyProductController, to name the product that
            was purchased, or that was out of stock. 

