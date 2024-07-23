import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    public Page page;
    private Playwright playwright;
    private Browser browser;




   @BeforeSuite
    public void setPlaywright(){
        this.playwright =Playwright.create();
    }
    @BeforeMethod
    public void setBrowser(){
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        launchOptions.setChannel("chrome");
        this.browser =playwright.chromium().launch(launchOptions);
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        this.page=context.newPage();
    }
    @AfterMethod
    public void closeBrowser(){
       page.close();
       browser.close();
    }
    @AfterSuite
    public void closePlayWright(){
       playwright.close();
    }

}
