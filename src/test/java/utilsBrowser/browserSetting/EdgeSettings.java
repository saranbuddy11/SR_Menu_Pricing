package utilsBrowser.browserSetting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class EdgeSettings implements BrowserSettings {
    private DesiredCapabilities capabilities = DesiredCapabilities.edge();

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return capabilities;
    }

    @Override
    public HashMap<String, Object> getPreferences() {
        return null;
    }

    DesiredCapabilities addAll(){
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        return getDesiredCapabilities();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(addAll());
    }
}
