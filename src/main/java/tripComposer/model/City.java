package tripComposer.model;

/**
 * Created by D.Zh. on 03.11.15.
 */

public class City {

    private int nId;

    private String sCityName;

    private Country oCountry;

    public City() {
    }


    public City(String sCityName, Country oCountry) {
        this.sCityName = sCityName;
        this.oCountry = oCountry;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsCityName() {
        return sCityName;
    }

    public void setsCityName(String sCityName) {
        this.sCityName = sCityName;
    }

    public Country getoCountry() {
        return oCountry;
    }

    public void setoCountry(Country oCountry) {
        this.oCountry = oCountry;
    }

    @Override
    public String toString() {
        return "City{" +
                "sCityName='" + sCityName + '\'' +
                '}';
    }
}
