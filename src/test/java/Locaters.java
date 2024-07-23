import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Locaters extends BaseTest{

@Test
    public void Test_Sause_Demo_Login_With_valid_Credential_and_Logout() throws InterruptedException {
        page.navigate("https://www.saucedemo.com/");
        Locator username=page.getByPlaceholder("username");
        username.fill("standard_user");
        Locator password =page.getByPlaceholder("password");
        password.fill("secret_sauce");
        Locator loginButton =page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login"));
        loginButton.click();
        System.out.println(page.title());
        Locator logo = page.locator("//div[@class='app_logo']");
        assertThat(logo).isVisible();
        assertThat(logo).containsText("Swag Labs");
        Locator menu = page.locator("#react-burger-menu-btn");
        menu.click();
        Locator logout=page.locator("#logout_sidebar_link");
        logout.click();
        Thread.sleep(2000);
        page.close();
    }
    @Test
    public void Test_google_Search( ){

        page.navigate("https://www.google.co.in/");
        System.out.println(page.title());
        Locator search=page.locator("//textarea[@class='gLFyf']");
        search.fill("find some good bags");
        System.out.println(page.title());
        page.close();
    }

}
