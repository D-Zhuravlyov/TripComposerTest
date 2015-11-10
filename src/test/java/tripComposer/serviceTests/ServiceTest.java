package tripComposer.serviceTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tripComposer.dao.CountryDAO;
import tripComposer.exceptions.DAOExceptions.CountryDAOException;
import tripComposer.exceptions.serviceExceptions.ServiceException;
import tripComposer.model.City;
import tripComposer.model.Country;
import tripComposer.service.CountryService;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by D.Zh.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-app-context.xml"})
public class ServiceTest {

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    CountryService countryService;


    @Test
    public void getAllCountriesTest() throws ServiceException {
        List<Country> testCountryList = countryService.getAllCountries();
        Assert.assertNotNull(testCountryList);
        for (Country c: testCountryList){
            System.out.println(c.toString());
        }
    }

    @Test
    public void saveCountryTest() throws ServiceException, CountryDAOException {
        Country testCountry2 = countryDAO.getCountryByName("Ukraine");
        List<City> testCityList = new ArrayList<City>();
        for (int i = 0; i < 5; i++) {
           testCityList.add(new City("New Test City" + i, testCountry2));
        }
        testCountry2.setAoCityList(testCityList);
        countryService.addCountry(testCountry2);

    }
}

