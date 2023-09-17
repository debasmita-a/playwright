package playwrightbasics;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create(); //start Playwright server
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280,571));
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/");
		//locators
		Locator salesBtn = page.locator("text = Contact Sales").last();
		
		salesBtn.hover();
		salesBtn.click();
		
		System.out.println("Contact Sales button clicked.");
		
		List<Locator> countryOptions = page.locator("//select[@name='Country']//option").all();
	
		System.out.println("No. of country options: "+ countryOptions.size());
		
		Locator name = page.locator("//input[@name='FullName']");
		name.hover();
		name.fill("Pooby");
		
		
		

	}

}
