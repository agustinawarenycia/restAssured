import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public abstract class baseTest {
//    @BeforeAll
//    public void setup(){
//        RestAssured.baseURI = ConfVariables.getHost();
//        RestAssured.basePath = ConfVariables.getPath();
//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//
//    }

    @BeforeClass
    public static void setup() {

        RestAssured.requestSpecification = defaultRequesSpecification();


    }

    private static RequestSpecification defaultRequesSpecification(){
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());

        return new RequestSpecBuilder()
                .setBaseUri(ConfVariables.getProperty("configuracion.properties","host"))
                .setBasePath(ConfVariables.getProperty("configuracion.properties","path"))

                .addFilters(filters)
                .setContentType(ContentType.JSON).build();
    }
}
