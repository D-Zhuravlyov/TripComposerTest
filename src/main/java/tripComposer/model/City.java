package tripComposer.model;

import javax.persistence.*;

/**
 * Created by D.Zh.
 */
@Entity
@Table(name = "City")
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", unique = true, nullable = false)
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Column(name = "city_name")
    public String getsCityName() {
        return sCityName;
    }

    public void setsCityName(String sCityName) {
        this.sCityName = sCityName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
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
