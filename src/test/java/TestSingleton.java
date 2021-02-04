import cn.bdqn.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created with IDEA 2019
 * author:bdqn kgc zhou qi chao
 * Date:2020/10/21
 * Time:10:14
 */
public class TestSingleton {

    @Test
    public void test01(){
        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        System.out.println(sqlSession1 == sqlSession2);
    }
}
