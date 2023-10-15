package com.neusoft.testmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.mapper.EmpMapper;
import com.neusoft.testmybatisplus.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {



    @Autowired
    EmpMapper empMapper;





    @Override
    public Message getAllEmps2() {
        Message message=new Message();

        List<Emp> list=empMapper.findAll2();

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }



    @Override
    public Message getEmplistByCondition1(QueryCondition1 queryConditon1) {
        Message message=new Message();
        List<Emp> list=empMapper.findByCondtion(queryConditon1);

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }



    @Override
    public Message findeByCondition2(QueryCondition2 queryCondition2) {
        Message message=new Message();
        List<Emp> list=empMapper.findeByCondition2(queryCondition2);

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);

        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }


        return message;

    }

    @Override
    public Message findeBySal(int sal) {

        Message message=new Message();

        List<Emp> list=empMapper.findeBySal(sal);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);

        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }


        return message;
    }

    @Override
    public Message findEmpByEnameAndEmpno(QueryCondition3 queryCondition3) {

        Message message=new Message();


        int num=empMapper.findEmpByEnameAndEmpno(queryCondition3);
        System.out.println("num:"+num);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;

    }

    @Override
    public Message getAllEmps3() {
        Message message=new Message();

        List<Emp> list=empMapper.findAll3();

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }



    @Override
    public Message getEmplistByCondition3(QueryCondition1 queryConditon1) {
        Message message=new Message();
        List<Emp> list=empMapper.findByCondtion3(queryConditon1);

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message findEmpByEnameAndEmpno3(QueryCondition3 queryCondition3) {
        Message message=new Message();


        int num=empMapper.findEmpByEnameAndEmpno3(queryCondition3);
        System.out.println("num:"+num);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message insertEmp(Emp emp) {
        Message message=new Message();

        int num = empMapper.insertToEmp(emp);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message updateEmp(Emp emp) {
        Message message=new Message();

        int num = empMapper.updateToEmp(emp);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message deleteEmp(int empno) {
        Message message = new Message();

        int num = empMapper.deleteToEmp(empno);

        if (num == 1) {
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;

    }

    @Override
    public Message getEmpDeptByEmpno(int empno) {
        Message message = new Message();
        Emp emp=empMapper.findEmpDeptByEmpno(empno);


        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }

    @Override
    public Message getEmpDept() {
        Message message = new Message();
        List<Emp> list=empMapper.findEmpDept();


        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }



    @Override
    public Message getEmpByEmpno(int empno) {
        Message message=new Message();

        Emp emp=empMapper.getEmpByEmpno(empno);
        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message getEmpByEmpno4(int empno) {
        Message message=new Message();

        Emp emp=empMapper.selectById(empno);
        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message getEmpBySal(int lowsal, int highsal) {
        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.between("sal",800,2000);
        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;


    }
    // select * from emp where  ename like 'w%'  or  deptno=20
    @Override
    public Message getEmpsByQueryCondition2(QueryCondition2 queryCondition2) {
        Message message=new Message();

        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("ename",queryCondition2.getEname())
                .or().eq("deptno",queryCondition2.getDeptno());
        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }

    //    select * from emp
    //QueryWrapper<Emp> qw=  Wrappers.query();
//        qw.apply("date_format( hiredate,'%Y-%m-%d')="+datestr)
//                .inSql("mgr","select empno from emp where ename like 'k%'");
    @Override
    public Message getEmpsByQueryCondition5(QueryCondition5 queryCondition5) {
        Message message=new Message();
//    where
//    date_format( hiredate,'%Y-%m-%d')="1980-12-17" or
//    empno in(
//            select empno from emp where deptno=20
//    )
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper
//                .apply("date_format( hiredate,'%Y-%m-%d')="
//                        +queryCondition5.getDateStr())

                .apply("date_format( hiredate,'%Y-%m-%d')= {0}",
                        queryCondition5.getDateStr())


                .or()
                .inSql("empno",
                        "select empno from emp where deptno="
                                +queryCondition5.getDeptno());
        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    //    ename like 's%' and (sal < 2000 or comm is not null)
    @Override
    public Message getEmpsByQueryCondition6(QueryCondition6 queryCondition6) {


        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("ename",queryCondition6.getStartLetter())
                .and(qw2->qw2.lt("sal",queryCondition6.getHighsal())
                        .or(queryCondition6.getCommIsNotNull()).isNotNull(queryCondition6.getCommIsNotNull(),"comm")
                );
        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }
    //    ename like 's%' or
//                   (sal < 2000
//                     and sal > 1000
//                     and comm is not null)
    @Override
    public Message getEmpsByQueryCondition62(QueryCondition6 queryCondition62) {

        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("ename",queryCondition62.getStartLetter())
                .or(qw2->qw2.lt("sal",queryCondition62.getHighsal())
                        .gt("sal", queryCondition62.getLowsal())
                        .isNotNull(queryCondition62.getCommIsNotNull(),"comm"));

        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }
    //(sal < 2000 or comm is not null) and name like 'm%'
    @Override
    public Message getEmpsByQueryCondition63(QueryCondition6 queryCondition63) {

        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.nested(
                        (qw2->qw2.lt("sal",queryCondition63.getHighsal())
                                .or()
                                .isNotNull(queryCondition63.getCommIsNotNull(),"comm"))
                )
                .likeRight("ename",queryCondition63.getStartLetter())
        ;

        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }

    //    select * from emp
//    where empno in (7369,7499,7521)
//    limit 0,1
    @Override
    public Message getEmpsByIdsAndLimit(List ids) {
        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("empno","ename","sal")
                .in("empno",ids)
                .last("limit 0,1");


        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;



    }

    //    select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL
//    from
//    where ename like '%m%' and sal < 3000
    @Override
    public Message getEmpsByQueryCondition64(QueryCondition6 queryCondition6) {
        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();
//        queryWrapper.select("empno","ename","JOB","MGR","hiredate","sal")
//                .like("ename",queryCondition6.getStartLetter())
//                .lt("sal",queryCondition6.getHighsal());
        queryWrapper
                .like("ename",queryCondition6.getStartLetter())
                .lt("sal",queryCondition6.getHighsal())
                .select(Emp.class,
                        info->{
                            System.out.println(info);
                            if(info.getColumn().equalsIgnoreCase("comm") || info.getColumn().equalsIgnoreCase("deptno") ) {
                                return false;
                            }else{
                                return true;
                            }

                        });
        ;



        List<Emp> list=empMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;


    }
    //    select deptno,sum(sal),avg(sal),max(sal),min(sal) from emp
//    group by deptno
//    having sum(sal)<10000
    @Override
    public Message getEmpGroupbySum(int sumval) {
        Message message=new Message();
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<>();

        queryWrapper.select("deptno","sum(sal) sumval","avg(sal) avgval","max(sal) maxval","min(sal) minval")
                .groupBy("deptno").having("sum(sal)<"+sumval);

//        List<EmpGroupByResult> list=empMapper.selectList(queryWrapper);
        List<Map<String, Object>> list= empMapper.selectMaps(queryWrapper);


        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }


    @Override
    public Message getEmpByEmpno3(int empno) {
        Message message=new Message();

        Emp emp=empMapper.getEmpByEmpno3(empno);
        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }
}
