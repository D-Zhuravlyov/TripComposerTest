package tripComposer.dao;


import tripComposer.exceptions.DAOExceptions.CityDAOException;
import tripComposer.model.City;

import java.util.List;

/**
 * Created by D.Zh.
 */

public interface CityDAO {

    void saveCity(City city) throws CityDAOException;

}
