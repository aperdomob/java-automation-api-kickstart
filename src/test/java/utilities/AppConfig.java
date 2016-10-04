package utilities;

import java.io.File;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

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
        if (instance == null){
          instance = new AppConfig();
        }
      }
    }
    
    return instance;
  }
  
  private void loadConfig() {
    try {
      CompositeConfiguration config = new CompositeConfiguration();
      config.addConfiguration(new SystemConfiguration());
        config.addConfiguration(new PropertiesConfiguration("config" + File.separator + "qa.properties"));

      this.urlBase = config.getString("urlBase");
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
  }
}
