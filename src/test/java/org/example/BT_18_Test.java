package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BT_18_Test {

     @Test
    void tc01(){
         Assert.assertEquals(BT_18.addArrayWith1(new int[] {0,9,9}), new int[]{1,0,0});
     }
    @Test
    void tc011(){
        Assert.assertEquals(BT_18.addArrayWith1(new int[] {9}), new int[]{1,0});
    }

    @Test
    void tc02(){
        Assert.assertEquals(BT_18.addArrayWith1(new int[]{0,1,2,3,4}), new int[]{0,1,2,3,5});
    }

    @Test
    void tc03(){
        Assert.assertEquals(BT_18.addArrayWith1(new int[]{11,9,9,8}), new int[]{11,9,9,9});
    }

    @Test
    void tc04(){
        Assert.assertEquals(BT_18.addArrayWith1(new int[]{-1,9,9,7}), new int[]{-1,9,9,8});
    }

    @Test
    void tc05(){
        Assert.assertEquals(BT_18.addArrayWith1(new int[]{1,2,5,3}), new int[]{1,2,5,4});
    }
}
