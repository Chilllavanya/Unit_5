import static org.junit.Assert.*;

import org.junit.Test;


public class FindMissingNumPerformanceTest{

    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private int max = 10;
    private FindMissingNum mn = new FindMissingNum();

    @Test(timeout=1000)
    public void testMissingNumber_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNum(missingMax, max);
            mn.findMissingNum(missingNone, max);
            mn.findMissingNum(missingSeven, max);
        }
    }

}