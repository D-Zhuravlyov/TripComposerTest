package tripComposer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripComposer.dao.CityDAO;
import tripComposer.dao.CountryDAO;
import tripComposer.exceptions.controllerExceptions.ControllerException;
import tripComposer.exceptions.serviceExceptions.ServiceException;
import tripComposer.model.City;
import tripComposer.model.Country;
import tripComposer.model.JSONResponse;
import tripComposer.model.POSTKey;
import tripComposer.service.CountryService;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by D.Zh.
 */
@Service
public class HTTPAsJSON {

    private static final Logger logger = LogManager.getFormatterLogger("JPACityDAO");


    @Autowired
    CityDAO cityDAO;

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    CountryService countryService;

    private final String KEY = "$1$12309856$euBrWcjT767K2sP9MHcVS/";

    private POSTKey postKey = new POSTKey(KEY, "echo-test");
    private ObjectMapper mapper;


    public HTTPAsJSON() {
        mapper =new ObjectMapper();
    }

    /*
    Method makes http request to postUrl server in JSON format.
    Request is built from tripComposer.model.POSTKey object.
     */
    public void doPOST(String postUrl) throws ControllerException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(postUrl);
        try {
            StringEntity postingString = new StringEntity(mapper.writeValueAsString(postKey));
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response =  httpClient.execute(post);
            proceedResponse(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.debug("Exception JsonProcessingException when mapping postKey as JSON string");
            throw new ControllerException("Exception when mapping postKey as JSON string");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.debug("Exception ClientProtocolException when httpClient executes string: %s.", post);
            throw new ControllerException("Exception when httpClient executes string.");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("Exception UnsupportedEncodingException when creating new StringEntity for setting it to httpPost.");
            throw new ControllerException("Exception when creating new StringEntity for setting it to httpPost.");
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Exception IOException when httpClient executes string: %s.", post);
            throw new ControllerException("Exception when httpClient executes string.");
        }
    }

    /*
    Parses HttpResponse to object tripComposer.model.JSONResponse.
    Gets countryList from JSONResponse and writes it to db.
     */
    private void proceedResponse(HttpResponse response) throws ControllerException {
        try {
            String responseContent = EntityUtils.toString(response.getEntity());
            JSONResponse jsonResponse = (mapper.readValue(responseContent, JSONResponse.class));
            List<Country> countryList = jsonResponse.getCountries();
            setCountry(countryList);
            countryService.addCountriesList(countryList);
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("IOException when reading Response content to JSONResponse");
            throw new ControllerException("Exception when reading Response content to JSONResponse");
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.debug("ServiceException when adding countryList");
            throw new ControllerException("Exception when adding countryList");
        }
    }


    /*
    Received response has only cityName property at list of cities.
    This method sets Country property to every city in the list.
     */
    private void setCountry(List<Country> countryList){
        if(countryList != null){
            for(Country c : countryList){
                for(City city :c.getAoCityList()){
                    city.setoCountry(c);
                }
            }
        }
    }


}
