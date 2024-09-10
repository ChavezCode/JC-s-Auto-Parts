
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