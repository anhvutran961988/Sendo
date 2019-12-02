# Sendo

*** FIRST NOTES ***
- The project is set up and run on Windows only. 
- The requirements and setup for other OS may vary somewhat.
- Source scripts are written in Java

*** REQUIREMENTS ***
- JDK 13 (or other compatible version) (JDK installer will automatically set up your environment variables)
- Eclipse for Java developers (link: https://www.eclipse.org/downloads/)
- Source scripts (attachment)
- Selenium Web Driver for Java (link: https://selenium.dev/downloads/) (already included in source scripts)
- Chromedriver (link: https://chromedriver.chromium.org/downloads) (already included in source scripts)

*** SETUP ***
- Install JDK + set up environment variables
- Install Eclipse + import project "Sendo" (you'll need to unzip the file first)
- Install Selenium Web Driver by means of adding external JARs (optional) (in case you want to do it for other languages)
- Copy chromedriver/geckodriver/internetexplorerdriver into the folder "driver" of the project (optional) (in case you want to use other versions of the drivers)

*** NOTES FOR PROJECT SCRIPTS ***
- I avoid navigating to category page via the link "sendo.vn/dam" because upon using the method "driver.navigate().to()", the session will be reset and I'll have to log  in again to order the product.
- There are points in the process that I have to use "Thread.sleep()" as the last measure. I'm not sure if it's because of the bad quality internet connection at my place. Even though I use Explicit Wait for all elements, sometimes Thread.sleep() is inevitable.
- I did try to dynamically handle the color and size buttons. There are cases where some colors or sizes are not available and to keep the test case running smoothly, we need dynamic scripts to ensure the web driver always clicks on the available buttons. However, I personally think it is too much an effort, it may destablize the scripts greatly since there are possibly a great amount of cases to handle. I think we can just simply prepare a good test data where all the button are always available and write scripts to click on the first buttons always. 
- The same for expected product name vs actual product name. Since the expected product name always contains product code but actual product name does not, any attempt to use assertEquals() on the two results will lead to a failure. We may try to trim the expected product name - remove the product code and keep the real product name only, but that's a trivial thing that requires too much effort and may destablize the scripts. Therefore, I simply change the way to compare the two results by ensuring that the expected product name always contain the actual product name.

*** NOTES FOR FRAMEWORK DESIGN ***
- My idea is to treat each class in the "test" package as a test suite. Each test suite will cover a certain feature of the application. Each individual class will contain many methods, each of which represents a test case. 
- In a real project, we may want to utilize Maven or something similar to handle the task of installing everything needed.
- In order to build a complete test framework, I may need to integrate some more unit testing elements (before test, after test, test handling method...) and utilize a plugin to properly produce a test report which includes a list of test suites, test cases and test status for each case. But for the purpose of this exam only, I think we don't need such a fancy design.   
