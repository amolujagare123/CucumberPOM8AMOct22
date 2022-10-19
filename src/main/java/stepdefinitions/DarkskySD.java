package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinitions.SharedSD.getDriver;

public class DarkskySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());

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

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

        ArrayList<Integer> timeList = darkSkyHome.getTimeList();
        ArrayList<Integer> timeDiffList = new ArrayList<>();
        for (int i=0;i<timeList.size()-1;i++) // i--> 11
        {
            int time1 = timeList.get(i); // 10
            int time2 = timeList.get(i+1); // 11
            int timeDiff = 0;

            if(time2>time1)
              timeDiff = time2 - time1;

            if(time2<time1) // 12 , 3
            {
               timeDiff = (time2 + 12) - time1;

               // timeDiff = ( time2+12 ) % 12;
            }
            timeDiffList.add(timeDiff);
        }
        System.out.println(timeDiffList);

        int size = timeDiffList.size();
        int frequency = Collections.frequency(timeDiffList,2);

        System.out.println("size="+size);
        System.out.println("frequency="+frequency);

        boolean result = (size==frequency);

        Assert.assertTrue("all differences are not 2",result);
    }

    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void iVerifyTodaySLowestAndHighestTempIsDisplayedCorrectly() {

        ArrayList<Integer> expected = darkSkyHome.getTempList();
        ArrayList<Integer> actual = darkSkyHome.getTimelineTempList();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("Temperature is incorrect",expected,actual);
    }
}
