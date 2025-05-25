package FrameworkApacha_POI_API;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

    public static void main(String[] args) throws IOException {
        DataDriven obj = new DataDriven();
        ArrayList data = obj.getDataDriven("Add Profile");
        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
        //driver.findElment(by.xpath("fddfed")).sendkeys(data.get(0));
        //driver.findElment(by.xpath("fddfed")).sendkeys(data.get(1));


    }
}
