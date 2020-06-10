package TraditionalTestsV1;

import common.DataProviders;
import common.PropertyManager;
import common.TestGroups;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import testSteps.FashionAppTraditionalSteps;

public class TraditionalTestsV1 {
    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void crossDeviceElementsV1Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV1Uri());
        fashionAppSteps.validateElementsOnFashionApp();
    }

    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void shoppingExperienceV1Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV1Uri());
        fashionAppSteps.setFilterBlackColorAndValidateResults();
    }

    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void productDetailsV1Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV1Uri());
        fashionAppSteps.setFilterBlackColor();
        fashionAppSteps.selectFirstItemFromResultsAndValidateProductPage();
        fashionAppSteps.checkElementAttributes();
    }
}