package playwrightbasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create(); //bydefault - headless mode
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://google.com");
		System.out.println("Page title is: "+page.title());
		System.out.println("Page url is: "+page.url());
		page.close();
		browser.close();
		playwright.close();

	}

}
