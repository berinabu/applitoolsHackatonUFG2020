package common;

import org.openqa.selenium.Dimension;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

public class DataProviders {

    @DataProvider(name = "deviceDimensions")
    public Iterator<Object[]> mobileScreenSizes() {
        ArrayList<Object[]> dimensions = new ArrayList<>();

        dimensions.add(new Dimension[]{new Dimension(1200, 700)});
        dimensions.add(new Dimension[]{new Dimension(768, 700)});
        dimensions.add(new Dimension[]{new Dimension(500, 700)});

        return dimensions.iterator();
    }
}
