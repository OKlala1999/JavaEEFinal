package com.example.hw.controller;


import com.example.hw.db.model.Homework;
import com.example.hw.db.model.Student;
import com.example.hw.db.model.StudentHomework;
import com.example.hw.db.model.Teacher;
import com.example.hw.db.service.HomeworkService;
import com.example.hw.db.service.StudentHomeworkService;
import com.example.hw.db.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 老师操作控制器
 * 17301092 符永乐
 */

@Controller
@RequestMapping("/app/teacher/")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    StudentHomeworkService studentHomeworkService;

    @RequestMapping("tLoginPage")//跳转到教师登录界面接口
    public String teacherLoginPage(){
        return "/index.jsp";
    }

    @RequestMapping(value = "tLogin")//根据学号的姓名登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        System.out.println(id + password);
        Optional<Teacher> result = teacherService.findById(Integer.valueOf(id));
        Teacher t=new Teacher();
        if(result.isPresent()){
             t = result.get();
        }
        if (t.getId() == Integer.valueOf(id) && t.getPassword().equals(password)) {
            req.getSession().setAttribute("login", "1");
            req.setAttribute("tid", id);
            req.getRequestDispatcher("/index/index.jsp").forward(req, resp);
            System.out.println("登陆成功");
        } else {
            req.setAttribute("error", "账号密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            System.out.println("登陆失败");
        }
    }

    @RequestMapping("registerPage")
    public String toRegisterPage(){
        return "/tregister.jsp";
    }

    @RequestMapping("tRegister")
    public void sRegister(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name=req.getParameter("name");
        System.out.println(id + password);
        Teacher t=new Teacher(Integer.valueOf(id),name,password);
        teacherService.addTeacher(t);
        req.setAttribute("message", "注册成功");
        req.getRequestDispatcher("/tregister.jsp").forward(req, resp);
    }

    @RequestMapping("addStudentPage")//跳转到添加学生界面接口
    public void addStudentPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        req.getRequestDispatcher("/addStudent.jsp").forward(req,resp);
    }

    @RequestMapping("addHomeworkPage")//跳转发布作业界面
    public void addHomeworkPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        req.getRequestDispatcher("/addHomework.jsp").forward(req,resp);
    }

    @RequestMapping("addHomework")//发布作业处理
    private void addHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {//老师添加作业
        String title=req.getParameter("hwTitle");
        String content=req.getParameter("hwContent");
        String deadline=req.getParameter("deadline");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long createTime=System.currentTimeMillis();
        Date date=new Date(createTime);
        String create=simpleDateFormat.format(date);
        System.out.println(create);
        Homework hw=new Homework(0,title,content,create,deadline);
        System.out.println(hw.toString());
        homeworkService.addHomework(hw);
        req.setAttribute("message","添加成功");
        req.getRequestDispatcher("/addHomework.jsp").forward(req,resp);
    }

    @RequestMapping("listHomework")//跳转展示作业列表界面
    public void listHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<Homework> list=homeworkService.findAll();
        req.setAttribute("hList",list);
        req.getRequestDispatcher("/listHomework.jsp").forward(req,resp);
    }

    @RequestMapping("listStudentHomework")//根据选中作业查看学生提交情况
    public void listStudentHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id=req.getParameter("hwID");
        int hid=Integer.valueOf(id);
        List<StudentHomework> list= studentHomeworkService.findByhomeworkId(hid);
        req.setAttribute("shList",list);
        req.getRequestDispatcher("/listStudenthw.jsp").forward(req,resp);
    }


}
