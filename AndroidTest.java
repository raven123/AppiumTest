
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
import static org.junit.Assert.assertEquals;
public class AndroidTest {
private AppiumDriver driver;


@Before
public void setUp() throws Exception {
URL netURL=new URL("http://127.0.0.1:4723/wd/hub");
File classpathRoot = new File(System.getProperty("user.dir"));
File appDir = new File(classpathRoot, "Application");
File app = new File(appDir, "jionews25.apk");
DesiredCapabilities capabilities = new DesiredCapabilities();
//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
capabilities.setCapability("deviceName","Android");
capabilities.setCapability("platformVersion", "4.4.2");
capabilities.setCapability("platformName","Android");
capabilities.setCapability("app", app.getAbsolutePath());
capabilities.setCapability("appPackage", "com.jio.news");
capabilities.setCapability("appActivity", "activities.LoginActivity");
driver = new AppiumDriver(netURL, capabilities);
	
	
}
@After
public void tearDown() throws Exception {
//driver.quit();
}
@Test
public void apiDemo(){
/*WebElement el = driver.findElement(By.name("Animation"));
assertEquals("Animation", el.getText());*/
	
	WebElement userNameTextBox = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[0]"));
	userNameTextBox.sendKeys("raven1234");
//assertEquals("API Demos", el.getText());
//el = driver.findElement(By.name("App"));

List<WebElement> els = driver.findElementsByClassName("android.widget.TextView");
assertEquals("Activity", els.get(2).getText());
}
}