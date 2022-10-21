package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsStarRatings {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {
        Assert.assertTrue("This is not booking search result",
                getDriver().getTitle().contains("Hotels in Goa"));

    }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars) // 5 stars
     {
         hotelsSearchResult.clickStarRating(stars.split(" ")[0]);

     }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {
       int actualRating = hotelsSearchResult.getStarRating();
       int expected =  Integer.parseInt(stars.split(" ")[0]);  // "5 stars" --> 5

        System.out.println("actualRating="+actualRating);
        System.out.println("expected="+expected);
    }

    @Then("I verify system displays all hotels within {string} Km radius from beach")
    public void i_verify_system_displays_all_hotels_within_km_radius_from_beach(String string) {

    }

    @Then("I verify {string} is within the search result")
    public void iVerifyIsWithinTheSearchResult(String expectedHotel) {

        ArrayList<String> hotelsList = hotelsSearchResult.getHotelsList();
        boolean flag = false;
        for (int i=0;i<hotelsList.size();i++)
        {
            System.out.println(hotelsList.get(i));

            if(hotelsList.get(i).contains(expectedHotel)) {
                flag = true;
                break;
            }
        }

        System.out.println("expectedHotel="+expectedHotel);

        Assert.assertTrue(expectedHotel+":This hotel is not there in the " +
                "hotel list on the search result page",flag);

    }
}
