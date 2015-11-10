package tripComposer.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tripComposer.exceptions.DAOExceptions.CityDAOException;
import tripComposer.model.City;


import java.util.List;

/**
 * Created by D.Zh.
 */
@Transactional
public class JPACityDAO implements CityDAO {

    private static final Logger logger = LogManager.getFormatterLogger("JPACityDAO");

    private SessionFactory sessionFactory;

    @Autowired
    public JPACityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCity(City city) throws CityDAOException {
        if (city != null) {
            try {
                sessionFactory.getCurrentSession().saveOrUpdate(city);
            } catch (HibernateException e) {
                logger.debug("Exception when saving city: %s", city);
                throw new CityDAOException("Exception when saving city: " + city);
            }
        }
    }


}
