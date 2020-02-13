import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @Author CX
 * @Date 2020/2/13 22:46
 * @Version 1.0
 * @Description：
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;

    /*hush类型的，每个值都要加一个key,就像是map集合*/

    @Test
    public void setValue(){
        redisTemplate.boundHashOps("nameHash").put("1","a");
        redisTemplate.boundHashOps("nameHash").put("2","b");
        redisTemplate.boundHashOps("nameHash").put("3","c");
        redisTemplate.boundHashOps("nameHash").put("4","d");
    }

    /*
    * 提取所有的key
    * */
    @Test
    public void getKey(){
        Set keys = redisTemplate.boundHashOps("nameHash").keys();
        System.out.println(keys);
    }
    /*
    * 提取所有的value
    * */
    @Test
    public void getValue(){
        List values = redisTemplate.boundHashOps("nameHash").values();

        System.out.println(values);
    }

    /*
    * 根据key取值
    * */
    @Test
    public void getValueByKey(){
        String value = (String) redisTemplate.boundHashOps("nameHash").get("1");

        System.out.println(value);
    }
    /*
    * 根据key移除值
    * */
    @Test
    public void removeByKey(){
      redisTemplate.boundHashOps("nameHash").rename("2");

    }
}
