package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    protected TestInfo testInfo;

    public Browser browser() {
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setAutoDriverDownload(true);
        browserConfiguration.setChromeOptions(chomeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chomeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--disable-notifications","--incognito");
        return options;
    }
}
