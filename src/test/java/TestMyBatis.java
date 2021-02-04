import cn.bdqn.mybatis.bean.User;
import cn.bdqn.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IDEA 2019
 * author:bdqn kgc zhou qi chao
 * Date:2020/10/19
 * Time:15:49
 */
public class TestMyBatis {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testGetCount(){
        //UserDao userDao = new UserDaoImpl();
        //userDao.getCount();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getCount(new User()));
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
