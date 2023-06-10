import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void minimumDeleteSumTest1() {
        String s1 = "sea";
        String s2 = "eat";
        int output = 321;
        Assert.assertEquals(output, new Solution().minimumDeleteSum(s1, s2));
    }

    @Test
    public void minimumDeleteSumTest2() {
        String s1 = "delete";
        String s2 = "leet";
        int output = 403;
        Assert.assertEquals(output, new Solution().minimumDeleteSum(s1, s2));
    }
}
