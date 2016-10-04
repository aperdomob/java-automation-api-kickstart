package utilities;

public class BaseRequest {

  protected String urlBase;
  
  public BaseRequest() {
    this.urlBase = AppConfig.getInstance().getUrlBase();
  }
  
  protected String concatenateUrl(String urlPart) {
    return this.urlBase + urlPart;
  }
}
