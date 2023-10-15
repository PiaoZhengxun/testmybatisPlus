package com.neusoft.testmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.testmybatisplus.config.MyCommonUtil;
import com.neusoft.testmybatisplus.dto.LoginUserinfoBean;
import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.UserinfoDate;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.EmpMapper;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IEmpService;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootTest
class TestmybatisplusApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    IUserinfoService iUserinfoService;

    @Autowired
    IEmpService iEmpService;

    // select * from emp where empno=#{empno}
    @Test
    public void test1001(){
        Emp emp= empMapper.selectById(7369);
        System.out.println(emp);
    }

    //    select * from emp
    @Test
    public void test1002(){
        QueryWrapper queryWrapper=new QueryWrapper();
        List<Emp> list= empMapper.selectList(queryWrapper);
        printList(list);
    }
    @Test
    public void test100202(){
        List<Emp> list=iEmpService.list();
        printList(list);
    }

    // select * from emp where empno in (7369,7499,7521)
    @Test
    public void test1003(){
        List ids=new ArrayList();
        ids.add(7369);
        ids.add(7499);
        ids.add(7521);

        List<Emp> list=empMapper.selectBatchIds(ids);
        printList(list);
    }

    @Test
    public void test100302(){
        List ids= Arrays.asList(7369,7499,7521);
        List<Emp> list=empMapper.selectBatchIds(ids);
        list.forEach(System.out::println);

    }

    // select * from userinfo where username=#{username}  and password=#{password}
    // List<Userinfo> list
    @Test
    public void test1004(){
        Message message=new Message();
        LoginUserinfoBean loginUserinfoBean=inputUsernamePassword();
        Map loginUserinfoMap=new HashMap();
        loginUserinfoMap.put("username",loginUserinfoBean.getUsername());
        loginUserinfoMap.put("password",loginUserinfoBean.getPassword());

        //username=#{username}   map.key=#{map.value}
        List<Userinfo> list=userinfoMapper.selectByMap(loginUserinfoMap);

        if(list.size()<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(list.size()==1){
            Userinfo u1=list.get(0);
            if(u1.getStatus()==1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            }else if(u1.getStatus()==0){
                message.setStatusCode(501);
                message.setMsg("Contact to system admin");
                message.setObj(u1);
            }
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

        System.out.println(message);

    }


    @Test
    public void test1005(){
        Userinfo userinfo= inputUserinfo();
        userinfo.setStatus(1);
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        userinfo.setHiredate(localDate);
        Message message=new Message();
//        int num=userinfoMapper.insertUserinfo(userinfo);
        int num=userinfoMapper.insert(userinfo);
        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }

        System.out.println(message);


    }
    @Test
    public void test100502(){
        Userinfo userinfo= inputUserinfo(); // input
        Message message=iUserinfoService.insertUserinfo3(userinfo); //test service
//       MyCommonUtil myCommonUtil=new MyCommonUtil();
        MyCommonUtil.printMessage(message);

    }


    @Test
    public void test100503(){
        UserinfoDate userinfoDate= inputUserinfoDate(); // input
        Message message=iUserinfoService.insertUserinfo4(userinfoDate); //test service
//       MyCommonUtil myCommonUtil=new MyCommonUtil();
        MyCommonUtil.printMessage(message);

    }


    // select * from userinfo
    // where username=#{username}   and   password=#{password}
    @Test
    public void test1006(){
        Message message=new Message();
        LoginUserinfoBean loginUserinfoBean=inputUsernamePassword();
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("username",loginUserinfoBean.getUsername())
                .eq("password",loginUserinfoBean.getPassword());
// select * from userinfo where username= tom  and   password=123456
        List<Userinfo> list=userinfoMapper.selectList(queryWrapper);
        if(list.size()<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(list.size()==1){
            Userinfo u1=list.get(0);
            if(u1.getStatus()==1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            }else if(u1.getStatus()==0){
                message.setStatusCode(501);
                message.setMsg("Contact to system admin");
                message.setObj(u1);
            }
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

        System.out.println(message);
    }


    @Test
    public void test100602(){

        LoginUserinfoBean loginUserinfoBean=inputUsernamePassword();//1. input

        Userinfo userinfo=new Userinfo();                      //2.requestmapping
        userinfo.setUsername(loginUserinfoBean.getUsername());  //set values to params
        userinfo.setPassword(loginUserinfoBean.getPassword());


        Message message=iUserinfoService.verifyUserinfoBySelectMap(userinfo);  //3. test service

        printMessage(message);  //4. check the result
    }








    @Test
    //select * from emp   where deptno =20  and  sal>1000
    public void test1007(){
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("deptno",20).gt("sal",600);
        List<Emp> list=empMapper.selectList(queryWrapper);
        printList(list);
    }

    // select * from userinfo where username like '%t%' and password =123456
    @Test
    public void test1008(){
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("username","t").eq("password",123456);
        List<Userinfo> list=userinfoMapper.selectList(queryWrapper);
        printList(list);


    }


    // select * from userinfo where sal>=800 and sal<=2000
    @Test
    public void test1009(){
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
//        queryWrapper.ge("sal",800).
        queryWrapper.ge("sal",800).le("sal",2000);
        List<Emp> list=empMapper.selectList(queryWrapper);
        printList(list);
    }
    @Test
    public void test100902(){
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.between("sal",800,2000);
        List<Emp> list=empMapper.selectList(queryWrapper);
        printList(list);

    }
    @Test
    public void test100903(){

        Message message=iEmpService.getEmpBySal(800,2000);
        System.out.println(message);

    }

    @Test
    public void test1010(){
        QueryCondition2 queryCondition2=inputQueryCondition2();
        Message message=iEmpService.getEmpsByQueryCondition2(queryCondition2);
        printMessage(message);

    }


    @Test
    public void test1011(){

        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("sal");

        IPage<Emp> page = new Page<>(3, 2);
        IPage<Emp> empIPage=empMapper.selectPage(page,queryWrapper);

        printList(empIPage.getRecords());

    }








    private void printMessage(Message message){
        if(message.getStatusCode()!=200){
            System.err.println(message.getStatusCode());
            System.err.println(message.getMsg());
        }else{
            System.out.println(message.getStatusCode());
            System.out.println(message.getMsg());
            if(message.getObj()!=null){
                if(message.getObj() instanceof Collection){
                    ((Collection) message.getObj()).forEach(System.out::println);
                }else{
                    System.out.println(message.getObj());
                }
            }

        }




    }


    // input ename deptno
    private QueryCondition2 inputQueryCondition2(){
        QueryCondition2 queryCondition2=new QueryCondition2();
        Scanner scanner=new Scanner(System.in);
        String ename=null;
        int deptno=0;

        System.out.println("Input ename:");
        ename=scanner.next();
        System.out.println("Input deptno:");
        deptno=scanner.nextInt();


        queryCondition2.setEname(ename);
        queryCondition2.setDeptno(deptno);


        return queryCondition2;
    }





    // input username password
    private Userinfo inputUserinfo(){
        Userinfo userinfo=new Userinfo();
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        String nickname=null;
        String email=null;
        int age=0;

        System.out.println("Input Username:");
        username=scanner.next();
        System.out.println("Input Password:");
        password=scanner.next();
        System.out.println("Input nickname:");
        nickname=scanner.next();
        System.out.println("Input email:");
        email=scanner.next();
        System.out.println("Input age:");
        age=scanner.nextInt();

        userinfo.setUsername(username);
        userinfo.setPassword(password);
        userinfo.setNickname(nickname);
        userinfo.setEmail(email);
        userinfo.setAge(age);



        return userinfo;
    }

    private UserinfoDate inputUserinfoDate(){
        UserinfoDate userinfo=new UserinfoDate();
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        String nickname=null;
        String email=null;
        int age=0;

        System.out.println("Input Username:");
        username=scanner.next();
        System.out.println("Input Password:");
        password=scanner.next();
        System.out.println("Input nickname:");
        nickname=scanner.next();
        System.out.println("Input email:");
        email=scanner.next();
        System.out.println("Input age:");
        age=scanner.nextInt();

        userinfo.setUsername(username);
        userinfo.setPassword(password);
        userinfo.setNickname(nickname);
        userinfo.setEmail(email);
        userinfo.setAge(age);



        return userinfo;
    }



    // input username password
    private LoginUserinfoBean inputUsernamePassword(){
        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        System.out.println("Input Username:");
        username=scanner.next();
        System.out.println("Input Password:");
        password=scanner.next();
        loginUserinfoBean.setUsername(username);
        loginUserinfoBean.setPassword(password);
        return loginUserinfoBean;
    }




    private void printList(List list){
        Iterator i=list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }



    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("date:          " + date);
        System.out.println("localDateTime: " + localDateTime);
    }



    @Test
    void contextLoads() {



    }



}
