package cn.bdqn.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IDEA 2019
 * author:bdqn kgc zhou qi chao
 * Date:2020/10/21
 * Time:10:07
 */
public class MyBatisUtils {

    private static SqlSession sqlSession;

    private MyBatisUtils(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession(){

        return sqlSession;
    }

    public static void closeSqlSession(){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
