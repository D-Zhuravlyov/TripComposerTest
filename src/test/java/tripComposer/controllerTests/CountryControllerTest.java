package tripComposer.controllerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tripComposer.controller.HTTPAsJSON;
import tripComposer.exceptions.controllerExceptions.ControllerException;

/**
 * Created by D.Zh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-app-context.xml"})
public class CountryControllerTest {

    @Autowired
    HTTPAsJSON httpjson;

    @Test
    public void doHTTPPostTest() throws ControllerException {
        httpjson.doPOST("http://tripcomposer.net/rest/test/countries/get");
    }


}
