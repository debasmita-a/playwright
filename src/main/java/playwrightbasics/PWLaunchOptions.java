package playwrightbasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PWLaunchOptions {

	public static void main(String[] args) {
		
		//create connection to Playwright server
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setHeadless(false);
		lp.setChannel("chrome");
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(lp);
		Page page = browser.newPage();
		page.navigate("https://google.com");

	}

}
