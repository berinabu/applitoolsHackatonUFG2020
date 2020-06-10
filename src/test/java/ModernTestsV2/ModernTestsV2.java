package ModernTestsV2;

import common.PropertyManager;
import common.TestGroups;
import org.testng.annotations.Test;
import testSteps.FashionAppModernSteps;

public class ModernTestsV2 {
    @Test(groups = TestGroups.MODERN)
    public void crossDeviceElementsV1ModernTest() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPageAndCheckWindow(PropertyManager.getInstance().getV2Uri(),
                "Task 1", "Cross-Device Elements Test");
    }

    @Test(groups = TestGroups.MODERN)
    public void Task2() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV2Uri(),
                "Task 2", "Filter Results");
        fashionAppModernSteps.filterResultsAndCheckProductRegion();
    }

    @Test(groups = TestGroups.MODERN)
    public void Task3() {
        FashionAppModernSteps fashionAppModernSteps = new FashionAppModernSteps();

        fashionAppModernSteps.navigateToPage(PropertyManager.getInstance().getV2Uri(),
                "Task 3", "Product Details test");
        fashionAppModernSteps.filterResults();
        fashionAppModernSteps.openFirstItemFromResultsAndCheckWindow();
    }
}
