package pb;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LongPress extends BaseTest {

    @Test
    public void LongPressGesture() throws MalformedURLException, URISyntaxException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        //Long press action
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),"duration",2000));

        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");
        System.out.println("Menu Text: " + menuText);
    }
}
