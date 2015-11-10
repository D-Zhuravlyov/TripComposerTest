package tripComposer.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tripComposer.exceptions.DAOExceptions.CountryDAOException;
import tripComposer.model.Country;


import java.util.List;

/**
 * Created by D.Zh.
 */
@Transactional
public class JPACountryDAO implements CountryDAO {

    private static final Logger logger = LogManager.getFormatterLogger("JPACountryDAO");

    private SessionFactory sessionFactory;

    @Autowired
    public JPACountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCountry(Country country) throws CountryDAOException {
        if(country != null) {
            try {
                sessionFactory.getCurrentSession().saveOrUpdate(country);
            } catch (HibernateException e) {
                logger.debug("Exception while saving Country. Country: %s", country);
                e.printStackTrace();
                throw new CountryDAOException("Exception while saving Country ");
            }
        }
    }

    public List<Country> getAllCountries() throws CountryDAOException {
       try {
           List<Country> allCountries = (List<Country>) sessionFactory.getCurrentSession()
                   .createCriteria(Country.class)
                   .list();
            return allCountries;
       }
       catch (HibernateException e){
           logger.debug("Exception while getting all Country List. ");
           e.printStackTrace();
           throw new CountryDAOException("Exception while getting all Country List. ");
       }
    }

    public Country getCountryById(int id) throws CountryDAOException {
        try{
            return sessionFactory.getCurrentSession().get(Country.class, id);
        }
        catch (HibernateException e){
            logger.debug("Exception while getting Country by id. ID: %s", id);
            e.printStackTrace();
            throw new CountryDAOException("Exception while getting Country by id. ");
        }
    }

    public Country getCountryByName(String countryName) throws CountryDAOException {
        try {
            return (Country) sessionFactory.getCurrentSession()
                    .createCriteria(Country.class)
                    .add(Restrictions.like("sCountryName", countryName)).uniqueResult();
        }
        catch (HibernateException e){
            logger.debug("Exception while getting Country by name. Name: %s", countryName);
            e.printStackTrace();
            throw new CountryDAOException("Exception while getting Country by name. Name: " +countryName);
        }
    }
}
