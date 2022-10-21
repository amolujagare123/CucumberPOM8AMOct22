package pages;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By allRatings = By.xpath("//div[@data-testid='rating-stars']");
    By allStarsElements = By.xpath("//div[@data-testid='rating-stars']/span");
    By hotelsList = By.xpath("//div[@data-testid='title']");


    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotelsList);
    }


    public void clickStarRating(String rating) // 5 ,4
    {

        getDriver().navigate().refresh();

      //  JavascriptExecutor js = (JavascriptExecutor) getDriver();
     //   js.executeScript("arguments[0].click();",getDriver().findElements(starRating));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        By starRating = By.xpath("//input[@name='class="+rating+"']");
        clickOn(starRating);
    }

    public  int getStarRating()
    {

        getDriver().navigate().refresh();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        int starRating =0;

       int allRatingBlocks = getDriver().findElements(allRatings).size();
       System.out.println("allRatingBlocks="+allRatingBlocks); // 25

       int allStars = getDriver().findElements(allStarsElements).size();
        System.out.println("allStars="+allStars); // 125

        starRating = allStars / allRatingBlocks;
        System.out.println("starRating="+starRating); // 5

        return starRating;
    }
}
