package tripComposer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tripComposer.dao.CityDAO;
import tripComposer.dao.CountryDAO;
import tripComposer.exceptions.DAOExceptions.DAOException;
import tripComposer.exceptions.serviceExceptions.ServiceException;
import tripComposer.model.City;
import tripComposer.model.Country;

import java.util.List;

/**
 * Created by D.Zh.
 */
@Service
public class SimpleCountryService implements CountryService {

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    CityDAO cityDAO;

    private static final Logger logger = LogManager.getFormatterLogger("SimpleCountryService");

    public SimpleCountryService() {
    }

    @Transactional
    public void addCountry(Country country) throws ServiceException {
        if (country != null) {
            try {
                countryDAO.saveCountry(country);
                for (City c : country.getAoCityList()) {
                    cityDAO.saveCity(c);
                }
            } catch (DAOException e) {
                logger.debug("Exception when adding Country. Country: %s", country);
                e.printStackTrace();
                throw new ServiceException("Exception when adding Country");
            }
        }
    }

    public List<Country> getAllCountries() throws ServiceException {
        try {
           return countryDAO.getAllCountries();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Exception when getting list of all Countries");
        }
    }

    @Transactional
    public void addCountriesList(List<Country> countryList) throws ServiceException {
        if (countryList != null) {
            for (Country c : countryList) {
                addCountry(c);
            }
        }
    }

}
