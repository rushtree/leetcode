package rushtree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindRedundantDirectedConnectionTest {

    FindRedundantDirectedConnection findRedundantDirectedConnection=new FindRedundantDirectedConnection();
    @Test
    public void testCycleno2()
    {
       /* 5 <- 1 -> 2
               ^    |
               |    v
               4 <- 3*/
        int[][] a={{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[]ans= findRedundantDirectedConnection.findRedundantDirectedConnection(a);
        Assert.assertEquals(ans[0],4);
        Assert.assertEquals(ans[1],1);
    }

    @Test
    public void testCycle2()
    {
              /*   4
                  /
                 v
                 1
                /  ^
                v    \
                2 -->3*/

        int[][] a={{1,2},{2,3},{3,1},{4,1}};
        int[]ans= findRedundantDirectedConnection.findRedundantDirectedConnection(a);
        Assert.assertEquals(ans[0],3);
        Assert.assertEquals(ans[1],1);
    }

    @Test
    public void testNoCycle()
    {
        int[][] a={{1,2}, {1,3}, {2,3}};
        int[]ans= findRedundantDirectedConnection.findRedundantDirectedConnection(a);
        Assert.assertEquals(ans[0],2);
        Assert.assertEquals(ans[1],3);
    }

}