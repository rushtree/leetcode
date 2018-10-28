package test;

import org.junit.Assert;
import org.junit.Test;
import rushtree.AllOne;

public class TestAllOne {
    @Test
    public void testInc() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("hello", allOne.getMinKey());

        allOne.inc("leet");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("leet", allOne.getMinKey());
    }

    // ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
    //         [[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]

    @Test
    public void test2() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("goodbye", allOne.getMinKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("code", allOne.getMinKey());
        allOne.dec("hello");
        allOne.getMaxKey();
        Assert.assertEquals("code", allOne.getMinKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        allOne.getMinKey();
        Assert.assertEquals("goodbye", allOne.getMinKey());
    }

    // ["AllOne","inc","inc","inc","dec","inc","inc","getMaxKey","dec","dec","dec","getMaxKey"]
    //         [[],["hello"],["world"],["hello"],["world"],["hello"],["leet"],[],["hello"],["hello"],["hello"],[]]
    @Test
    public void test3() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("hello");
        allOne.dec("world");
        allOne.inc("hello");
        allOne.inc("leet");
        allOne.getMaxKey();
        allOne.dec("hello");
        allOne.dec("hello");
        allOne.dec("hello");
        Assert.assertEquals("leet", allOne.getMaxKey());
        ;
    }

}
