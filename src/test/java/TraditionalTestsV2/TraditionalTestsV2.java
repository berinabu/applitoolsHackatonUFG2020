package TraditionalTestsV2;

import common.DataProviders;
import common.PropertyManager;
import common.TestGroups;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import testSteps.FashionAppTraditionalSteps;

public class TraditionalTestsV2 {
    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void crossDeviceElementsV2Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV2Uri());
        fashionAppSteps.validateElementsOnFashionApp();
    }

    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void shoppingExperienceV2Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV2Uri());
        fashionAppSteps.setFilterBlackColorAndValidateResults();
    }

    @Test(groups = TestGroups.TRADITIONAL, dataProvider = "deviceDimensions", dataProviderClass = DataProviders.class)
    public void productDetailsV2Test(Dimension dimension) {
        FashionAppTraditionalSteps fashionAppSteps = new FashionAppTraditionalSteps();

        fashionAppSteps.setWindowDimension(dimension);
        fashionAppSteps.navigateToFashionApp(PropertyManager.getInstance().getV2Uri());
        fashionAppSteps.setFilterBlackColor();
        fashionAppSteps.selectFirstItemFromResultsAndValidateProductPage();
        fashionAppSteps.checkElementAttributes();
    }
}