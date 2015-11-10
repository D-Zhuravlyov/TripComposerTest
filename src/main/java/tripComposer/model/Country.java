package tripComposer.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by D.Zh.
 */
@Entity
@Table(name = "Country")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", unique = true, nullable = false)
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Column(name = "country_name")
    public String getsCountryName() {
        return sCountryName;
    }

    public void setsCountryName(String sCountryName) {
        this.sCountryName = sCountryName;
    }

    @Column(name = "county_ISO_code")
    public String getsCountryISOCode() {
        return sCountryISOCode;
    }

    public void setsCountryISOCode(String sCountryISOCode) {
        this.sCountryISOCode = sCountryISOCode;
    }

    @OneToMany(mappedBy = "oCountry", fetch = FetchType.LAZY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (sCountryName != null ? !sCountryName.equals(country.sCountryName) : country.sCountryName != null)
            return false;
        return !(sCountryISOCode != null ? !sCountryISOCode.equals(country.sCountryISOCode) : country.sCountryISOCode != null);

    }


}
