package playwrightbasics;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightTraceviewer {
		  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      //starting a tracing
		      context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
		      Page page = context.newPage();
		      page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
		      page.getByPlaceholder("First Name").click();
		      page.getByPlaceholder("First Name").fill("Test fname");
		      page.getByPlaceholder("First Name").press("Tab");
		      page.getByPlaceholder("Last Name").fill("Test lname");
		      page.getByPlaceholder("Last Name").press("Tab");
		      page.getByPlaceholder("E-Mail").fill("testemail224@gmail.com");
		      page.getByPlaceholder("E-Mail").press("Tab");
		      page.getByPlaceholder("Telephone").fill("2453673829");
		      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).click();
		      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("testEmail");
		      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).press("Tab");
		      page.getByPlaceholder("Password Confirm").fill("testEmail");
		      page.getByPlaceholder("Password Confirm").press("Tab");
		      page.getByRole(AriaRole.CHECKBOX).check();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Account")).click();
		      page.locator("#top-links").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Logout")).click();
		      System.out.println("flow completed.");
		      //stop tracing
		      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		    }
		  }
		}
