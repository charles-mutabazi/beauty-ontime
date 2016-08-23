package models;

/**
 * Created by charl on 21/08/2016.
 */
public class ServiceItem {

    private String icon_name;
    private String service_name;

    public ServiceItem(String icon_name, String service_name){
        this.icon_name = icon_name;
        this.service_name = service_name;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
