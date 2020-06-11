package ModernTestsV1;

import common.PropertyManager;
import common.TestGroups;
import org.testng.annotations.Test;
import testSteps.FashionAppModernSteps;

public class ModernTestsV1 {
    @Test(groups = TestGroups.MODERN)
    public void crossDeviceElementsV1ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPageAndCheckWindow(PropertyManager.getInstance().getV1Uri(), "Task 1", "Cross-Device Elements Test");
    }

    @Test(groups = TestGroups.MODERN)
    public void FilterResultsV1ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV1Uri(), "Task 2", "Filter Results");
        fashionAppModernSteps.filterResultsAndCheckProductRegion();
    }

    @Test(groups = TestGroups.MODERN)
    public void ProductDetailsV1ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV1Uri(), "Task 3", "Product Details test");
        fashionAppModernSteps.filterResults();
        fashionAppModernSteps.openFirstItemFromResultsAndCheckWindow();
    }
}