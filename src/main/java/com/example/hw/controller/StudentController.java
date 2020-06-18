package com.example.hw.controller;


import com.example.hw.db.model.Homework;
import com.example.hw.db.model.Student;
import com.example.hw.db.model.StudentHomework;
import com.example.hw.db.service.HomeworkService;
import com.example.hw.db.service.StudentHomeworkService;
import com.example.hw.db.service.StudentService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */

@Controller
@RequestMapping("app/student/")
public class StudentController {

    @Autowired
    StudentHomeworkService studentHomeworkService;
    @Autowired
    StudentService studentService;
    @Autowired
    HomeworkService homeworkService;

    @RequestMapping("sLoginPage")//跳转到学生登录界面
    public String toStudentLogin() {
        return "/studentLogin.jsp";
    }

    @RequestMapping(value = "sLogin")//根据学号的姓名登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        System.out.println(id + password);

        Optional<Student> result = studentService.findById(Integer.valueOf(id));
        Student s=new Student();
        if(result.isPresent()){
            s = result.get();
        }
        if (s.getId() == Integer.valueOf(id) && s.getPassword().equals(password)) {
            req.getSession().setAttribute("login", "1");
            List<Homework> list = homeworkService.findAll();
            List<Homework> subList=new ArrayList<Homework>();
            List<Homework> toSubList=new ArrayList<Homework>();
            for(int i=0;i<list.size();i++){
                List<StudentHomework> shList=studentHomeworkService.findByHidAndSid(list.get(i).getId(),s.getId());
                if(shList.size()>0){
                    subList.add(list.get(i));
                }else{
                    toSubList.add(list.get(i));
                }
            }
            req.setAttribute("hList", toSubList);
            req.setAttribute("subList", subList);
            System.out.println(list.toString());
            req.setAttribute("student", s);
            list.clear();
            req.getRequestDispatcher("/student/listhomework.jsp").forward(req, resp);
            System.out.println("登陆成功");
        } else {
            req.setAttribute("error", "请重新输入学号姓名");
            req.getRequestDispatcher("/studentLogin.jsp").forward(req, resp);
            System.out.println("登陆失败");
        }
    }

    @RequestMapping("registerPage")
    public String toRegisterPage(){
        return "/sregister.jsp";
    }

    @RequestMapping("sRegister")
    public void sRegister(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name=req.getParameter("name");
        System.out.println(id + password);
        Optional<Student> result=studentService.findById(Integer.valueOf(id));
        if(result.isPresent()){
            req.setAttribute("message", "当前账号已存在，请重新注册");
            req.getRequestDispatcher("/sregister.jsp").forward(req, resp);
        }else {
            Student s=new Student(Integer.valueOf(id),name,password);
            studentService.addStudent(s);
            req.setAttribute("message", "注册成功");
            req.getRequestDispatcher("/sregister.jsp").forward(req, resp);
        }

    }

    @RequestMapping("submitPage")//跳转到学生提交作业页面
    public void submitPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String hwid=req.getParameter("hwID");
        Homework hw=homeworkService.findByHomeworkId(Integer.valueOf(hwid));
        req.setAttribute("ddl",hw.getDeadline());
        req.setAttribute("title",hw.getTitle());
        req.getRequestDispatcher("/student/submitPage.jsp").forward(req,resp);
    }

    @RequestMapping("submit")//学生提交作业
    public void submit(HttpServletRequest req, HttpServletResponse resp) throws Exception {//学生提交作业
        String sid=req.getParameter("sID");
        String content=req.getParameter("hwContent");
        String hwID=req.getParameter("hwID");
        String title=req.getParameter("hwTitle");

        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        System.out.println(currentDate);
        StudentHomework shw=new StudentHomework(0,Integer.valueOf(sid),Integer.valueOf(hwID),title,content,new Date() ,new Date(),"");
        studentHomeworkService.submitHomework(shw);

        Student s= studentService.findById(Integer.valueOf(sid)).get();
        List<Homework> list = homeworkService.findAll();
        List<Homework> subList=new ArrayList<Homework>();
        List<Homework> toSubList=new ArrayList<Homework>();
        for(int i=0;i<list.size();i++){
            List<StudentHomework> shList=studentHomeworkService.findByHidAndSid(list.get(i).getId(),s.getId());
            if(shList.size()>0){
                subList.add(list.get(i));
            }else{
                toSubList.add(list.get(i));
            }
        }
        req.setAttribute("hList", toSubList);
        req.setAttribute("subList", subList);
        System.out.println(list.toString());
        req.setAttribute("student", s);
        req.getRequestDispatcher("/student/listhomework.jsp").forward(req, resp);
    }

    @RequestMapping("updatePage")//跳转到学生提交作业页面
    public void updatePage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String hwid=req.getParameter("hwID");
        String sid=req.getParameter("sid");
        System.out.println(hwid+"   "+sid);
        List<StudentHomework> list=studentHomeworkService.findByHidAndSid(Integer.valueOf(hwid),Integer.valueOf(sid));
        StudentHomework studentHomework=list.get(0);
        System.out.println(studentHomework.toString());
        Homework hw=homeworkService.findByHomeworkId(Integer.valueOf(hwid));
        req.setAttribute("ddl",hw.getDeadline());
        req.setAttribute("title",hw.getTitle());
        req.setAttribute("hwContent",studentHomework.getHomeworkContent());
        req.getRequestDispatcher("/student/updatePage.jsp").forward(req,resp);
    }
    @RequestMapping("updateHomework")//学生更新作业
    public void updateHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {//学生提交作业
        String sid=req.getParameter("sID");
        String content=req.getParameter("hwContent");
        String hwID=req.getParameter("hwID");
        String title=req.getParameter("hwTitle");

        List<StudentHomework> result=studentHomeworkService.findByHidAndSid(Integer.valueOf(hwID),Integer.valueOf(sid));
        StudentHomework studentHomework=result.get(0);


        StudentHomework shw=new StudentHomework(studentHomework.getId(),Integer.valueOf(sid),Integer.valueOf(hwID),title,content,studentHomework.getSubmitTime() ,new Date(),"");
        studentHomeworkService.submitHomework(shw);
        Student s= studentService.findById(Integer.valueOf(sid)).get();

        List<Homework> list = homeworkService.findAll();
        List<Homework> subList=new ArrayList<Homework>();
        List<Homework> toSubList=new ArrayList<Homework>();
        for(int i=0;i<list.size();i++){
            List<StudentHomework> shList=studentHomeworkService.findByHidAndSid(list.get(i).getId(),s.getId());
            if(shList.size()>0){
                subList.add(list.get(i));
            }else{
                toSubList.add(list.get(i));
            }
        }
        req.setAttribute("hList", toSubList);
        req.setAttribute("subList", subList);
        req.setAttribute("student",s);
        req.getRequestDispatcher("/student/listhomework.jsp").forward(req,resp);
    }

}