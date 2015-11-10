package tripComposer.service;

import org.springframework.stereotype.Repository;
import tripComposer.exceptions.serviceExceptions.ServiceException;
import tripComposer.model.Country;

import java.util.List;


/**
 * Created by D.Zh.
 */
@Repository
public interface CountryService {

    void addCountry(Country country) throws ServiceException;
    List<Country> getAllCountries() throws ServiceException;
    void addCountriesList(List<Country> countryList) throws ServiceException;
}
