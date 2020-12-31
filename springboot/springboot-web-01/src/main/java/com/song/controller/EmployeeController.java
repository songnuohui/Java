package com.song.controller;

import com.song.dao.DepartmentDao;
import com.song.dao.EmployeeDao;
import com.song.pojo.Department;
import com.song.pojo.Employee;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class EmployeeController{
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }
    @GetMapping("/toAdd")
    public String toAdd(Model model){
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("department",department);
        return "emps/add";
    }
    @PostMapping("/insert")
    public String insert(Employee employee){
        /**添加员工信息**/
        //System.out.println("sdjfldsk"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**去员工的修改信息页面**/
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.getById(id);
        model.addAttribute("emp",employee);
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("department",department);
        return "emps/update";
    }
    /**提交修改更新信息**/
    @PostMapping("/update")
    public String update(Employee employee){
        Integer id=employee.getId();
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**删除员工**/
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/index";
    }

}
