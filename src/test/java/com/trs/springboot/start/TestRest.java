package com.trs.springboot.start;

import org.junit.After;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;
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


}
