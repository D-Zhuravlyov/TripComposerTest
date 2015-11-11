package tripComposer.model;

import java.util.List;

/**
 * Created by D.Zh.
 */
public class JSONResponse {

    private String type;
    private String time;
    private String echo;

    private List<Country> countries;

    public JSONResponse() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "JSONResponse:" +
                " {" +
                "type= '" + type + '\'' +
                ", time= '" + time + '\'' +
                ", countries= " + countries +
                ", echo= " + echo +
                '}';
    }
}
