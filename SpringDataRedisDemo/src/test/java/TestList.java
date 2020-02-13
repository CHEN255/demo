import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author CX
 * @Date 2020/2/13 22:33
 * @Version 1.0
 * @Description：
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestList {
    @Autowired
    private RedisTemplate redisTemplate;


    /*
    * 添加list类型数据：左压栈：就是从左边进，先进去的放在最右边
    * */
    @Test
    public void setLeftList(){
            redisTemplate.boundListOps("nameList").leftPush("赵");
        redisTemplate.boundListOps("nameList").leftPush("钱");
        redisTemplate.boundListOps("nameList").leftPush("孙");
        redisTemplate.boundListOps("nameList").leftPush("李");
    }
    /*
     * 添加list类型数据：左压栈：就是从左边进，先进去的放在最右边
     * */
    @Test
    public void setRightList(){
        redisTemplate.boundListOps("nameList").rightPush("赵");
        redisTemplate.boundListOps("nameList").rightPush("钱");
        redisTemplate.boundListOps("nameList").rightPush("孙");
        redisTemplate.boundListOps("nameList").rightPush("李");
    }

    /*
    * 得到数据
    * */
   @Test
    public void getList(){
//        range的意思是范围，所以参数传入获取从哪个下标到哪个下标的数据
        List nameList = redisTemplate.boundListOps("nameList").range(0, 10);
         System.out.println(nameList);
    }

    /*
    * 根据索引查询
    * */
    @Test
    public void getListByIndex(){
//      不管是左压栈还是右压栈，索引都是从左往右记
        String value =(String) redisTemplate.boundListOps("nameList").index(0);
        System.out.println(value);
    }

    /*
    * 移除某个元素
    * */
    @Test
    public void remove(){
        /*参数为：删除的个数，要删除的值*/
        redisTemplate.boundListOps("nameList").remove(1,"li");
    }

}
