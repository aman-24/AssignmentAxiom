# AssignmentAxiom
# Appium Java Mobile App testframework

Java based appium/selenium automation framework using appium, selenium , TestNG test runner , allure reporting , and maven build tool.

1.  Install **Maven** and impot maven project into your intellij or eclipse.
2.  Install allure and testng plugins to the IDE you are using. 
3.  Run TestNG.xml file under src/test/rresource, or run mvn test command.

# Problem Statement:
1) Download the Centrepoint app from Playstore
2) Write a code to launch the application using Appium on an emulator
3) On the home page, click the title “Departments”
4) Select the category as “Home & Living”
5) Select subcategory as “Home Furniture”
6) Select the first product from the list of products displayed. Click on the product.
7) Compare the product name and price displayed on the product detail page is the same as displayed in
previous step6.
8) Add 2 quantity of the product to cart
9) Click on Checkout Now
10) Now remove the product from the basket and click on “Start Shopping”
