package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By allRatings = By.xpath("//div[@data-testid='rating-stars']");
    By allStarsElements = By.xpath("//div[@data-testid='rating-stars']/span");

    public void clickStarRating(String rating) // 5 ,4
    {

        getDriver().navigate().refresh();

        By starRating = By.xpath("//input[@name='class="+rating+"']");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",getDriver().findElements(starRating));

        //clickOn(starRating);
    }

    public  int getStarRating()
    {
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
