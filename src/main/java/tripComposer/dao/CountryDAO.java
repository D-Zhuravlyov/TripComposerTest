package tripComposer.dao;



import tripComposer.exceptions.DAOExceptions.CountryDAOException;
import tripComposer.model.Country;

import java.util.List;

/**
 * Created by D.Zh.
 */

public interface CountryDAO {

    void saveCountry(Country country) throws CountryDAOException;

    List<Country> getAllCountries() throws CountryDAOException;

    Country getCountryById(int id) throws CountryDAOException;

    Country getCountryByName(String countryName) throws CountryDAOException;
}
