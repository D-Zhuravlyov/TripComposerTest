package tripComposer.model;

import java.util.List;

/**
 * Created by D.Zh. on 03.11.15.
 */
public class Country {

    private int nId;

    private String sCountryName;

    private String sCountryISOCode;

    private List<City> aoCityList;

    public Country() {
    }

    public Country(String sCountryName, String sCountryISOCode) {
        this.sCountryName = sCountryName;
        this.sCountryISOCode = sCountryISOCode;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsCountryName() {
        return sCountryName;
    }

    public void setsCountryName(String sCountryName) {
        this.sCountryName = sCountryName;
    }

    public String getsCountryISOCode() {
        return sCountryISOCode;
    }

    public void setsCountryISOCode(String sCountryISOCode) {
        this.sCountryISOCode = sCountryISOCode;
    }

    public List<City> getAoCityList() {
        return aoCityList;
    }

    public void setAoCityList(List<City> aoCityList) {
        this.aoCityList = aoCityList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nId=" + nId +
                ", sCountryName= '" + sCountryName + '\'' +
                ", aoCityList= " + aoCityList +
                '}';
    }
}
