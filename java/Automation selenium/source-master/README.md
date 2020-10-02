[![Circle CI](https://circleci.com/gh/selenium-webdriver-book/source.svg?style=svg)](https://circleci.com/gh/selenium-webdriver-book/source)

# Selenium WebDriver Book
## Pre-requisites

You'll need to install

* Java 8.
* Maven.
* Chrome.

Download the Application
---

    git clone git@github.com:selenium-webdriver-book/source.git
    cd source

Running Application
---
This is an example application with tests. To run the application:

	mvn jetty:run
	
When it is ready you'll see "Started Jetty Server" printed onto the console.  You can then view the sample HTML pages at <http://localhost:8080>.

To stop this web site, Ctrl+C, or:

	mvn jetty:stop
	
The Book Store
---

The application contains a dynamic bookstore at <http://localhost:8080/bookstore/>.
	
Running Tests
---
	
To run a single test (using the Maven Failsafe Plugin):

	mvn test-compile failsafe:integration-test failsafe:verify -Dit.test=HelloWebDriverIT

On just in another browser, other than Chrome:

	mvn ... -Dwebdriver.capabilities.browserName=firefox
	mvn ... -Dwebdriver.capabilities.browserName=htmlunit -Dwebdriver.screenshots.enabled=false
	mvn ... -Dwebdriver.capabilities.browserName=safari
	mvn ... -Dwebdriver.capabilities.browserName=phantomjs

To run remotely:

	mvn ... -Dwebdriver.remote=true -Dwebdriver.remote.url=$WD_URL
	
Slow Tests
---

To find slow tests:

    mvn clean install
    mvn surefire-report:failsafe-report-only
    open target/site/failsafe-report.html 
    
Chrome Mobile Emulation
---

Specifying known device:

    mvn ... -Dwebdriver.capabilities.browserName=chrome -Dwebdriver.capabilities.chromeOptions.mobileEmulation.deviceName="Apple iPad"
    
Specifying individual device attributes:

    mvn ... -Dwebdriver.capabilities.browserName=chrome \
        -Dwebdriver.capabilities.chromeOptions.mobileEmulation.deviceMetrics.width=768 \
        -Dwebdriver.capabilities.chromeOptions.mobileEmulation.deviceMetrics.height=1024 \
        -Dwebdriver.capabilities.chromeOptions.mobileEmulation.deviceMetrics.pixelRatio=2 \
        -Dwebdriver.capabilities.chromeOptions.mobileEmulation.userAgent='Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53' 
        
        
Appium
---
On iOS:

    mvn .. -Dwebdriver.remote=true \
        -Dwebdriver.remote.url=http://localhost:4723/wd/hub \
        -Dwebdriver.capabilities.deviceName="iPhone 5" \
        -Dwebdriver.capabilities.platformName=iOS \
        -Dwebdriver.capabilities.platformVersion=9.2 \
        -Dwebdriver.capabilities.browserName=safari

On Android (note that we disable screenshots and proxy):

    mvn .. -Dwebdriver.remote=true \
        -Dwebdriver.remote.url=http://localhost:4723/wd/hub \
        -Dwebdriver.capabilities.deviceName="Nexus" \
        -Dwebdriver.capabilities.platformName=Android \
        -Dwebdriver.capabilities.platformVersion=4.4 \
        -Dwebdriver.capabilities.browserName=browser \
        -Dwebdriver.screenshots.enabled=false \
        -Dwebdriver.proxy.enabled=false

Local Selenium Grid With Vagrant
---

You can run a mini Selenium Grid if you like:

    cd vagrant
    vagrant up 
    
Check it is working at <http://192.168.10.2:4444>. Please refer chapter 11 of the book for how to set-up Windows with IE10.

You can run your tests as follows:

    mvn clean install -Dwebdriver.remote=true -Dwebdriver.remote.url=http://192.168.10.2:4444/wd/hub

