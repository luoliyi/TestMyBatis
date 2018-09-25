package com.nf.mybatis.DAL;

import com.nf.mybatis.Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class UserDAL {

    public User getOneUserByUid(int uid){

        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream stream=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        //构建sqlSession的工厂
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlSession
        SqlSession session=ssf.openSession();
        /**
         * 映射sql的标识字符串，
         * com.zhangguo.mybatis01.dao.studentMapper是studentMapper.xml文件中mapper标签的namespace属性的值，
         * selectStudentById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        User user=session.selectOne("com.nf.mybatis.abc.selectUserByUid",uid);
        session.close();
        return user;
    }
    public int insert(User user){
        InputStream ip=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ip);
        SqlSession session=ssf.openSession();
        int result=session.insert("com.nf.mybatis.abc.addUser",user);
        session.commit();
        session.close();
        return result;
    }
    public int delete(int uid){
        InputStream ip=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ip);
        SqlSession session=ssf.openSession();
        int result=session.delete("com.nf.mybatis.abc.deleteUser",uid);
        session.commit();
        session.close();
        return result;
    }

    public int update(User user){
        InputStream ip=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ip);
        SqlSession sqlSession=ssf.openSession();
        int result=sqlSession.update("com.nf.mybatis.abc.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public User getOneUserByUname(String uname){
        InputStream ip=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ip);
        SqlSession session=ssf.openSession();
        User user=session.selectOne("com.nf.mybatis.abc.selectUserByName",uname);
        return user;
    }

    public List<User> getAllUser(){
        InputStream ip=UserDAL.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ip);
        SqlSession session=ssf.openSession();
        List<User> userList=session.selectList("com.nf.mybatis.abc.selectAll");
        return userList;
    }
}
