import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @Author CX
 * @Date 2020/2/13 22:26
 * @Version 1.0
 * @Description：
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestSet {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.boundSetOps("nameSete").add("cc");
        redisTemplate.boundSetOps("nameSete").add("aa");
        redisTemplate.boundSetOps("nameSete").add("ss");
        redisTemplate.boundSetOps("nameSete").add("bb");
    }

    @Test
    public void getValue(){
        Set nameSets= redisTemplate.boundSetOps("nameSete").members();
        System.out.println(nameSets);
    }

    /*
    * 删除某一个
    * */
    @Test
    public void deletValue(){
       redisTemplate.boundSetOps("nameSete").remove("cc");

    }

    /*
    * 删除整个
    * */
    @Test
    public void deleteAll(){
        redisTemplate.delete("nameSete");
    }
}
