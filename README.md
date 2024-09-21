
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
            If the statemet returns false, then the product name is still added to the model as an attribute, but it is not decremented, and will be displayed in the outofstock page.
    Changes made in the buySuccess AND the outofstock files: The buySuccess template was created to display a confirmation page to the customer, letting them know they successfully bought a product. The outofstock template
            was created to display a message to the customer to let them know that the product is out of stock. the thymeleaf expressions in both, pulls information from the model in the BuyProductController, to name the product that
            was purchased, or that was out of stock. 

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

    File Name: Part, BootStrapData, InhousePartForm.html, OutSourcePartForm.html & application.properties.
    Line Number where changes were made:
        On Part: 34 - 48, 67, 73, 78 - 93
        On BootStrapData: 54 & 55, 66 & 67, 78 & 79, 90 & 91, 102 & 103
        On InhousePartForm.html: 25 - 29
        On OutSourcedPartForm.html: 25 - 32
        On application.properties: 6
    Changes made in Part file: Added an @AssertTrue validation and created an isValid method to check and make sure that inventory is between min and max values. I also initiated int minInv and int maxInv and added them to the Part consturctor, and created
            their associated getter and setter methods. 
    Changes made on the BootStrapData file: Modified the sample inventory to include the min and max values for each sample part. 
    Changes made on the InhousePartForm.html file & the OutSourcedPartForm.html file: I modified the thymeleaf template and added additional selection expressions to get the minimum and maximum inventory values.
    Changes made in the application.properties file: renamed the file the persistent storage is saved to.

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

    File Name: Part, OutSourcedPartForm.html, InhousePartForm.html, InventoryValidation, AddOutsourcedPartController, AddInhousePartController, productForm.html, ValidEnufParts & EnufPartsValidator.
    Line Number where changes were made:
        On Part: 40-49
        On OutSourcedPartForm.html:  20, 22, 26 and 29
        On InhousePartForm.html: 21, 25, 28 and 31
        On InventoryValidation: New file created
        On AddOutsourcedPartController: 28 & 29, 42 - 46
        On AddInhousePartController: 29 & 30, 42 - 47
        On productForm.html: 41 & 42, 52 & 53, 67 & 68, 79 & 80.
        On ValidEnufParts: 21
        On EnufPartsValidator: 37
    Changes made in Part file: Added additional validation for the name and price fields. Also commented out the AssertTrue validation created for Task G since it was not needed after creating a seperate validation for minimum and maximum inventory.
    Changes made in the OutSourcedPartForm and the InhousePartForm: Changed input type to text, to avoid the NumberFormatException error that was thrown if the inventory field was left blank. I also added more validation code in my thymeleaf template associated with the name and price fields.
    Changes made in the InventoryValitation file: I created service methods to help with returnting messages and performing validations on the inventory field, if it fell below the minimum or the maximum values when being updated. Thwo methods were created in the InventoryValidation class, one for the
        AddInhousePartController, and one for the AddOutsourcedPartController. 
    Changes made in the AddOutsourcedPartController and AddInhousePartController file: Used the custom validator method and added logic to the submitForm field to check to see if there is an error in the inventory field to display that error into the form. 
    Changes made in the productForm.html file: added min and max inventory to associated parts table and available parts table.
    Changes made in the ValidEnufParts file: Updated the message to display a message that lets the user know that there aren't enough associated parts in the inventory. 
    Changes made in the EnufPartsValidator: Added more logic to the isValid method to prevent the associated part inventory from going below the minimum inventory, which will display the message in the ValidEnufParts file. 

I. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

    File Name: Pom.xml, PartTest.
    Line Number where changes were made: 
        On pom.xml: 54 - 56
        On PartTest: 89 - 105
    Changes made in the pom.xml file: added a more recent version of junit to the project. 
    Changes made in the PartTest file: Added unit tests for maximum and minimum inventory using the assertEquals method.
