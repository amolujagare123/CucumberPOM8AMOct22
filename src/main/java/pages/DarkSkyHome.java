package pages;

import org.openqa.selenium.By;

public class DarkSkyHome extends Base{

     By rawCurrentTemp = By.xpath("//span[@class='summary swap']");
     By rawTimelineTemp = By.xpath("//span[@class='first']//span");

     public int getCurrentTemp()
     {
         String rawTempStr = getTextFromElement(rawCurrentTemp);
         // 73˚ Clear. --->
         String[] stArr = rawTempStr.split("˚"); // {"73"," Clear."}
         String tempStr =  stArr[0]; // 73
         return Integer.parseInt(tempStr);
     }

     public int getTimelineTemp()
     {
         String rawTempStr = getTextFromElement(rawTimelineTemp);//73°
         String tempStr = rawTempStr.split("°")[0]; // {"73"}
         return Integer.parseInt(tempStr);
     }

}
