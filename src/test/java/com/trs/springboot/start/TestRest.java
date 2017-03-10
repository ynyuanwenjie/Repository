package com.trs.springboot.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spi.test.SPIService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Created by yuanwenjie on 2016/11/26.
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class TestRest {
    ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

   @Before
    public void before(){
        System.out.println("----------------------before--------------------------");

       Map<String,Object> objectMap = new HashMap<>();
       objectMap.put("1","yuanwenjie");
       objectMap.put("2","liuling");
       threadLocal.set(objectMap);
    }

    @After
    public void after(){
        System.out.println("----------------------end--------------------------");
    }
    @Test
    public void test01(){
       /* Iterator it = sun.misc.Service.providers(SPIService.class);
        System.out.println(it.hasNext());
        while (it.hasNext()) {
            SPIService service = (SPIService) it.next();
            service.test();
        }*/

        ServiceLoader<SPIService> loader = ServiceLoader.load(SPIService.class);
        System.out.println(loader.iterator());
        for (SPIService service : loader) {
            service.test();
        }

    }

}
