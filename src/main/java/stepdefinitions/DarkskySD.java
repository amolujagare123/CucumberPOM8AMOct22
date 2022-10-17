package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

public class DarkskySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {


    }
    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        int expected = darkSkyHome.getTimelineTemp();
        int actual = darkSkyHome.getCurrentTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("temperatures are not equal"
                ,expected,actual);
    }

}
