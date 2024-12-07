package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查看浏览器版本：chrome://version/
 *
 */
public class BaiduTest {
    public static void main(String[] args) throws Exception {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        BaiduTest baiduTest = new BaiduTest();
        baiduTest.test1();
        baiduTest.test2();
    }

//    @todo 加个win和mac的判断
//    public static String ChromePath = "D:\\software\\Google\\Chrome\\Application\\chromedriver.exe";
    public static String ChromePath = "/Applications/Google Chrome.app";

    @Test
    public void test1() throws Exception{
        System.setProperty("webdriver.chrome.driver", ChromePath);
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().maximize();

        WebElement search_setting = webDriver.findElement(By.xpath("//*[@id=\"s-usersetting-top\"]"));
        Actions action = new Actions(webDriver);
        action.clickAndHold(search_setting).perform();  //鼠标右键点击指定的元素

        Thread.sleep(8000);

        webDriver.quit();
    }


    @Test
    public void test2() throws Exception{
        System.setProperty("webdriver.chrome.driver", ChromePath);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        WebElement input = driver.findElement(By.id("kw"));

        //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);

        //删除多输入的一个m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        //输入空格键+“教程”
        input.sendKeys(Keys.SPACE);
        input.sendKeys("教程");
        Thread.sleep(2000);

        //ctrl+a 全选输入框内容
        input.sendKeys(Keys.CONTROL,"a");
        Thread.sleep(2000);

        //ctrl+x 剪切输入框内容
        input.sendKeys(Keys.CONTROL,"x");
        Thread.sleep(2000);

        //ctrl+v 粘贴内容到输入框
        input.sendKeys(Keys.CONTROL,"v");
        Thread.sleep(2000);

        //通过回车键盘来代替点击操作
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();
    }
}
