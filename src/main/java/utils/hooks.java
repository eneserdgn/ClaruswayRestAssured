package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before
    public void before() {
        requestSpecificationFactory.initializeRequestSpecification();
    }

    @After
    public void after() {
    }


}
