package com.kim.kaframework;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.kim.kaframework", appContext.getPackageName());
    }

    @Test
    public void MapTest()throws Exception{

        HashMap<String,String> map = new HashMap<>();
        map.put("value1","value1");
        map.put("value2","value2");

        Iterator kv = map.entrySet().iterator();
        Iterator k = map.keySet().iterator();
        Iterator v = map.values().iterator();

        for (int i = 0; i < map.size();i++){
            Map.Entry entry = (Map.Entry)kv.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Log.e(sysData.TAG,key.toString()+"-"+value.toString());
        }


    }

    @Test
    public void getpackage() throws Exception{
        Context context = InstrumentationRegistry.getTargetContext();

        String mypackage = context.getPackageName();

        Log.e(sysData.TAG,mypackage);
    }

    @Test
    public void testInsert() throws Exception{
        String str = "app";
        String strutf8 = URLDecoder.decode(str,"Unicode");
        Log.e(sysData.TAG,strutf8);
    }


}
