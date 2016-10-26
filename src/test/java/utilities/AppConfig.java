package utilities;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class AppConfig {
  private static final Object lock = new Object();
  private static volatile AppConfig instance;

  private String urlBase;

  private AppConfig() {
    this.loadConfig();
  }

  public String getUrlBase() {
    return this.urlBase;
  }

  public static AppConfig getInstance() {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new AppConfig();
        }
      }
    }

    return instance;
  }

  private void loadConfig() {
    Configurations configs = new Configurations();

    try {
      Configuration config = configs.properties(new File("config" + File.separator + "qa.properties"));
      this.urlBase = config.getString("urlBase");
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
  }
}
