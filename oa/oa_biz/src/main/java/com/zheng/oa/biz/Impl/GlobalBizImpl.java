package com.zheng.oa.biz.Impl;

import com.zheng.oa.biz.GlobalBiz;
import com.zheng.oa.dao.EmployeeDao;
import com.zheng.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee login(String sn, String password) {
        Employee employee=employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    @Override
    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
