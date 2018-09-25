package com.nf.mybatis.DAL;

import com.nf.mybatis.Entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDALTest {

    @Test
    public void getOneUserByUid() {
        UserDAL dal=new UserDAL();
        User u=dal.getOneUserByUid(4);
        System.out.println(u.toString());
    }

    @Test
    public void insert() {
        UserDAL dal=new UserDAL();
       int result= dal.insert(new User("obea",20,0,"my name is obea!"));
        System.out.println(result);
    }

    @Test
    public  void  delete(){
        UserDAL dal=new UserDAL();
        int result=dal.delete(3);
        System.out.println(result);
    }

    @Test
    public  void  update(){
        UserDAL dal=new UserDAL();
        int result=dal.update(new User(17,"obea1",19,0,"my name is obea!"));
        System.out.println(result);
    }

    @Test
    public void getOneUserByUname() {
        UserDAL dal=new UserDAL();
        User user=dal.getOneUserByUname("tom");
        System.out.println(user.toString());
    }

    @Test
    public  void  getAllUser(){
        UserDAL dal=new UserDAL();
        List<User>userList=dal.getAllUser();
        for (User u:userList){
            System.out.println(u.toString());
        }
    }
}