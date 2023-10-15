package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
public interface IEmpService extends IService<Emp> {

    public Message getAllEmps2();



    public Message getEmplistByCondition1(QueryCondition1 queryConditon1);
    public Message findeByCondition2(QueryCondition2 queryCondition2);
    public Message findeBySal(int sal);


    public Message  findEmpByEnameAndEmpno(QueryCondition3 queryCondition3);

    public Message getAllEmps3();
    public Message getEmpByEmpno3(int empno);
    public Message getEmplistByCondition3(QueryCondition1 queryConditon1);
    public Message  findEmpByEnameAndEmpno3(QueryCondition3 queryCondition3);

    public Message  insertEmp(Emp emp);
    public Message  updateEmp(Emp emp);
    public Message  deleteEmp(int empno);

    public Message  getEmpDeptByEmpno(int empno);
    public Message  getEmpDept();


    public Message getEmpByEmpno(int empno);
    public Message getEmpByEmpno4(int empno);


    public Message getEmpBySal(int lowsal,int highsal);


    // select * from emp where  ename like 'w%'  or  deptno=20
    public Message getEmpsByQueryCondition2(QueryCondition2 queryCondition2);


//    select * from emp
//    where  date_format( hiredate,'%Y-%m-%d')  = '1981-05-01'
//    and
//    mgr in (select empno from user where ename like 'k%')

//   "  date_formate( hiredate,'%Y-%m-%d')="


//   hiredate  = "1981-05-01"
//                                      data type of hiredate
//    date_format( hiredate,'%Y-%m-%d')   date--->str
//                                     12-17-1980--->"1980-12-17"
//    if("1980-12-17" .equals("1981-05-01"))


//    select * from emp
//    where
//    date_format( hiredate,'%Y-%m-%d')="1980-12-17" AND
//    empno in(
//            select empno from emp where deptno=20
//    )

    public Message getEmpsByQueryCondition5(QueryCondition5 queryCondition5);

//QueryWrapper<Emp> qw=  Wrappers.query();
//        qw.apply("date_format( hiredate,'%Y-%m-%d')="+datestr)
//                .inSql("mgr","select empno from emp where ename like 'k%'");



    //    ename like 's%' and (sal < 2000 or comm is not null)
    public Message getEmpsByQueryCondition6(QueryCondition6 queryCondition6);

    //    ename like 's%' or (sal < 2000 and sal > 1000 and comm is not null)
    public Message getEmpsByQueryCondition62(QueryCondition6 queryCondition62);


    //   (sal < 2000 or comm is not null) and name like 'm%'
    public Message getEmpsByQueryCondition63(QueryCondition6 queryCondition63);


    //    select * from emp
//    where empno in (7369,7499,7521)
//    limit 0,1
    public Message getEmpsByIdsAndLimit(List ids);

    //    select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL
//    from
//    where ename like '%m%' and sal < 3000
    public Message getEmpsByQueryCondition64(QueryCondition6 queryCondition6);



    public Message getEmpGroupbySum(int sumval);
}
