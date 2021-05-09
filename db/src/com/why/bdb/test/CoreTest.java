package com.why.bdb.test;

import com.why.bdb.Core;
import org.junit.Assert;
import org.junit.Test;


public class CoreTest {

    @Test
    public void insertTypeNode(){
        Core core = new Core();
        core.createRoot();
        String typeName = "测试";
        long nodeProperty = core.createTypeNode(typeName);
        Assert.assertNotNull(nodeProperty);
    }
}
