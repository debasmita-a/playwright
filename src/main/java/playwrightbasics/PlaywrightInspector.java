package playwrightbasics;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class PlaywrightInspector {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
      page.getByPlaceholder("First Name").click();
      page.getByPlaceholder("First Name").fill("Fname");
      page.getByPlaceholder("Last Name").click();
      page.getByPlaceholder("Last Name").fill("Lname");
      page.getByPlaceholder("E-Mail").click();
      page.getByPlaceholder("E-Mail").fill("pwemail01@gmail.com");
      page.getByPlaceholder("Telephone").click();
      page.getByPlaceholder("Telephone").fill("1234567899");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).click();
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("PWtest");
      page.getByPlaceholder("Password Confirm").click();
      page.getByPlaceholder("Password Confirm").fill("PWtest");
      page.getByLabel("Yes").check();
      page.getByRole(AriaRole.CHECKBOX).check();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your Account Has Been Created!")).click();
    }
  }
}
