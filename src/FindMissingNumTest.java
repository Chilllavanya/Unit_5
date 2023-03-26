import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class FindMissingNumTest {
    private int[] missingMax = {1,2,3,4,5,6,7,8,9};
    private int[] missingNone = {1,2,3,4,5,6,7,8,9,10};
    private int[] missingSeven = {1,2,3,4,5,6,8,9,10};
    private FindMissingNum fmn= new FindMissingNum();

    @Test
    public void testFindMissingNum_MissingMax(){
        assertEquals(10, fmn.findMissingNum(missingMax, 10));
    }

    @Test
    public void testFindMissingNum_MissingNone(){
        assertEquals(0, fmn.findMissingNum(missingNone, 10));
    }

    @Test
    public void testFindMissingNum_MissingSeven(){
        assertEquals(7, fmn.findMissingNum(missingSeven, 10));
    }
}
