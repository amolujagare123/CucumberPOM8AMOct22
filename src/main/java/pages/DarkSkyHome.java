package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHome extends Base{

     By rawCurrentTemp = By.xpath("//span[@class='summary swap']");
     By rawTimelineTemp = By.xpath("//span[@class='first']//span");
     By timeListRaw = By.xpath("//span[@class='hour']/span");

     public ArrayList<Integer> getTimeList() // get the timeline times list in int format
     {
         ArrayList<String> rawTimeList = getElementTextList(timeListRaw);
         System.out.println(rawTimeList);
         // [10am, 12pm, 2pm, 4pm, 6pm, 8pm, 10pm, 12am, 2am, 4am, 6am]
         ArrayList<Integer> timeList = new ArrayList<>();

         for (int i=0;i<rawTimeList.size();i++)
         {
             String rawTime = rawTimeList.get(i); // "10am" // "10"
             int l = rawTime.length(); // 4
            // rawTime.length()-2
             String timeStr = rawTime.substring(0, l - 2); // 10
             int time = Integer.parseInt(timeStr);
             timeList.add(time);
         }
         System.out.println(timeList);

         return timeList;

     }

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
