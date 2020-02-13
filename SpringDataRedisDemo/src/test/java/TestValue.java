import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author CX
 * @Date 2020/2/13 22:06
 * @Version 1.0
 * @Description：
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    /*
    * 字符串类型的数据：value
    * */
    @Test
    public void setValue(){
        redisTemplate.boundValueOps("name").set("youjiuye");
    }
    @Test
    public void getValue(){
        String name = (String)redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void delete(){
        redisTemplate.delete("name");
    }
}
