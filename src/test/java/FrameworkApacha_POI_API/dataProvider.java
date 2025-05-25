package FrameworkApacha_POI_API;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class dataProvider {
    //multiple sets of data to our tests
    //arraypublic
    //5 sets of data as 5 arrays from data provider to your tests
    //then your test will run 5 times with 5 separate sets of data (arrays)

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, int id) {

        System.out.println(greeting + " " + communication + " " + id);
    }

    @DataProvider(name="driveTest")
    public Object[][] getData()
    {
        Object[][] data={{"hello","text",1},{"bye","message",143},{"solo","call",453}};
        return data;
    }


}
