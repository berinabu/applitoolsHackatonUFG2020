package ModernTestsV2;

import common.PropertyManager;
import common.TestGroups;
import org.testng.annotations.Test;
import testSteps.FashionAppModernSteps;

public class ModernTestsV2 {
    @Test(groups = TestGroups.MODERN)
    public void crossDeviceElementsV2ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPageAndCheckWindow(PropertyManager.getInstance().getV2Uri(), "Task 1", "Cross-Device Elements Test");
    }

    @Test(groups = TestGroups.MODERN)
    public void FilterResultsV2ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV2Uri(), "Task 2", "Filter Results");
        fashionAppModernSteps.filterResultsAndCheckProductRegion();
    }

    @Test(groups = TestGroups.MODERN)
    public void ProductDetailsV2ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV2Uri(), "Task 3", "Product Details test");
        fashionAppModernSteps.filterResults();
        fashionAppModernSteps.openFirstItemFromResultsAndCheckWindow();
    }
}
