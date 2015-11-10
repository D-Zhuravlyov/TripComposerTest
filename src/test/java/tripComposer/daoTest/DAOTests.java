package tripComposer.daoTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tripComposer.dao.CityDAO;
import tripComposer.dao.CountryDAO;
import tripComposer.exceptions.DAOExceptions.CityDAOException;
import tripComposer.exceptions.DAOExceptions.CountryDAOException;
import tripComposer.model.City;
import tripComposer.model.Country;

/**
 * Created by D.Zh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-app-context.xml"})
public class DAOTests {

    @Autowired
    CityDAO cityDAO;

    @Autowired
    CountryDAO countryDAO;



    @Test
    public void saveCountryTest() throws CountryDAOException {
        Country testCountry1 = new Country("Ukraine","UA");
        countryDAO.saveCountry(testCountry1);
    }


    @Test
    public void getAllCountriesTest() throws CountryDAOException {
        for(Country c: countryDAO.getAllCountries()){
            System.out.println(c.toString());
        }
    }

    @Test
    public void getCountryByNameTest() throws CountryDAOException {

        Country testCountry = new Country("England","EN");
        countryDAO.saveCountry(testCountry);
        Country testCountry2 = countryDAO.getCountryByName("England");
        Assert.assertNotNull(testCountry2);
        Assert.assertEquals(testCountry.getsCountryName(), testCountry2.getsCountryName());
        Assert.assertEquals(testCountry.getsCountryISOCode(), testCountry2.getsCountryISOCode());
    }


    @Test
    public void saveCityTest() throws CityDAOException, CountryDAOException {
        Country testCountry = new Country("England","EN");
        countryDAO.saveCountry(testCountry);
        testCountry = countryDAO.getCountryByName("England");
        System.out.println(testCountry);
        City testCity = new City("London",testCountry);
        cityDAO.saveCity(testCity);

    }
}
