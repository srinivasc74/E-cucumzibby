package com.zibby.auto;

import static com.zibby.auto.common.ComparatorAdapter.TOSTRING_CASE_INSENSITIVE_ORDER;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zibby.auto.common.BrowserTypes;

/**
 * Global configuration values.
 *
 * @author AF04261 mmorton
 * @author ddamron
 */
public final class Configuration {
    private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);

    private final static Properties prop;

    static {
        prop = new Properties();
        ConfigurationPropertyAdapter.populateProperties(prop);
        LOG.debug("Configuration:\n" + PrettyPrinter.prettyMap(prop, Optional.of(TOSTRING_CASE_INSENSITIVE_ORDER), "\n"));
    }

    private static String peek(String key) {
        return prop.getProperty(key);
    }

    /**
     * Peek for a required property. Will log a WARN if missing.
     *
     * @param key
     * @return
     */
    private static String peekR(String key) {
        String value = peek(key);
        if(null == value || value.isEmpty())
            LOG.warn("Missing property for key: " + key);
        return value;
    }

    private static boolean isValueMissing(String key, String value) {
        return null == value || value.isEmpty() || value.contains(key);
    }

    /**
     * Parses the integer value for the given key. If the value fails to parse the exception is logged
     * and the defaultValue is return.
     *
     * @param key the key for the property
     * @param defaultValue the default to use if parsing fails
     * @return the parsed value or fallback to defaultValue
     */
    private static int peek(String key, int defaultValue) {
        String value = peek(key);
        if(isValueMissing(key, value)) {
            LOG.info("No value provided for: " + key + " using default: " + defaultValue);
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch(Exception e) {
            LOG.warn("Invalid integer value: " + value + " for key: " + key + "; defaulting to: " + defaultValue);
            return defaultValue;
        }
    }

    private static float peek(String key, float defaultValue) {
        String value = peek(key);
        if(isValueMissing(key, value)) {
            LOG.info("No value provided for: " + key + " using default: " + defaultValue);
            return defaultValue;
        }
        try {
            return Float.parseFloat(value);
        } catch(Exception e) {
            LOG.warn("Invalid float value: " + value + " for key: " + key + "; defaulting to: " + defaultValue);
            return defaultValue;
        }
    }

    private static Boolean peek(String key, boolean defaultValue) {
        String value = peek(key);
        if(isValueMissing(key, value)) {
            LOG.info("No value provided for: " + key + " using default: " + defaultValue);
            return defaultValue;
        }
        try {
            return Boolean.valueOf(value);
        } catch(Exception e) {
            LOG.warn("Invalid boolean value: " + value + " for key: " + key + "; defaulting to: " + defaultValue);
            return defaultValue;
        }
    }

    /**
     * Wraps the value for the given key in Optional. If the value is not present, Optinonal.empty() is returned.
     * @param key
     * @return
     */
    private static Optional<String> peekOpt(String key) {
        String value = peek(key);
        if(isValueMissing(key, value)) {
            LOG.info("No value provided for: " + key);
            return Optional.empty();
        }
        return Optional.of(value);
    }

    public static final Boolean REMOTE = Boolean.valueOf(peekR("selenium.remote"));
    public static final BrowserTypes BROWSER = BrowserTypes.valueOf(peekR(ConfigurationKeys.BROWSER));
    public static final String SELENIUM_GRID_URL = peekR("selenium.gridurl");
    public static final Boolean DEMO = Boolean.valueOf(peekR("project.demo"));

    public static final String HOST = peek("aut.server");
    public static final Boolean USE_SSL = Boolean.valueOf(peekR("aut.useSSL"));

    public static final String MOBILE_DEVICE = peek("mobile.device");
    public static final int MOBILE_WIDTH = peek("mobile.width", 200);
    public static final int MOBILE_HEIGHT = peek("mobile.height", 600);
    public static final float MOBILE_PIXEL_RATIO = peek("mobile.pixel.ratio", 3.0f);

    public static final String CHROME_WEBDRIVER = peekR("webdriver.chrome.driver");
    public static final String IE_WEBDRIVER = peekR("webdriver.ie.driver");
    public static final String FIREFOX_WEBDRIVER = peekR("webdriver.gecko.driver");
    public static final boolean IS_PDF_DOWNLOAD_WEBDRIVER  = peek("webdriver.ispdf.driver", false);

    public static final String CONFLUENCE_USER = peek("confluence.user");
    public static final String CONFLUENCE_PASSWORD = peek("confluence.password");

    public static final String EXECUTION_ENVIRONMENT = peekR(ConfigurationKeys.EXECUTION_ENVIRONMENT).toUpperCase();
    public static final String NEW_LINE = System.lineSeparator();

    public static final int ELEMENT_TIMEOUT_MILLIS = peek("selenium.elementtimeout", 3000);
    public static final int PAGE_TIMEOUT_MILLIS = peek("selenium.pagetimeout", 3000);

    public static final boolean SET_BROWSERMOB_PROXY = true;

    public static final Brands BRAND = resolveBrand();

    public static final Optional<Integer> EXECUTION_ID = resolveExecutionId();

    public static final boolean SUPPRESS_SCREENSHOT = peek(ConfigurationKeys.SUPPRESS_SCREENSHOT, true);

    public static final Optional<String> SPLUNK_FILE = peekOpt(ConfigurationKeys.SPLUNK_FILE);

    private static Brands resolveBrand() {
        String brandVal = peek(ConfigurationKeys.BRAND);
        if(isValueMissing(ConfigurationKeys.BRAND, brandVal)) {
            LOG.warn("Brand (" + ConfigurationKeys.BRAND + ") not set.");
        } else {
            try {
                Brands brand = Brands.valueOf(brandVal);
                LOG.info("Brand: " + brand);
                return brand;
            } catch(Exception e) {
                LOG.error("Invalid Brand (" + ConfigurationKeys.BRAND + "): " + brandVal);
            }
        }
        LOG.info("Defaulting Brand to: " + Brands.ANTHEM);
        return Brands.ANTHEM;
    }

    private static Optional<Integer> resolveExecutionId() {
        String id = peek(ConfigurationKeys.EXECUTION_ID);
        if(isValueMissing(ConfigurationKeys.EXECUTION_ID, id)) {
            LOG.info("Execution Id (" + ConfigurationKeys.EXECUTION_ID + ") not set.");
        } else {
            try {
                Integer value = Integer.valueOf(id);
                LOG.info("Exeuction Id: " + value);
                return Optional.of(value);
            } catch (NumberFormatException nfe) {
                LOG.error("Invalid Execution Id (" + ConfigurationKeys.EXECUTION_ID + "): " + id);
            }
        }
        return Optional.empty();
    }

    public interface ComputerName {
        String COMPUTERNAME = "COMPUTERNAME";
        String HOSTNAME = "HOSTNAME";
        String UNKNOWN_COMPUTER = "Unknown Computer";
    }

    /**
     * Obtains the computer's name by checking {@link System#getenv()} first for the property
     * {@link ComputerName#COMPUTERNAME} and falling back to {@link ComputerName#HOSTNAME}. If neither are present then
     * {@link ComputerName#UNKNOWN_COMPUTER} is returned.
     *
     * @return a name
     */
    public static String getComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey(ComputerName.COMPUTERNAME))
            return env.get(ComputerName.COMPUTERNAME);
        else if (env.containsKey(ComputerName.HOSTNAME))
            return env.get(ComputerName.HOSTNAME);
        else
            return ComputerName.UNKNOWN_COMPUTER;
    }

    public static final String MOCK_ENV = "MockEnv";

    public static boolean isMockEnvironment() {
        return MOCK_ENV.equalsIgnoreCase(EXECUTION_ENVIRONMENT);
    }
}
