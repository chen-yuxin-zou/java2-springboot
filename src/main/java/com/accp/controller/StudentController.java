package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Student;
import com.accp.service.StudentService;
import com.github.pagehelper.PageInfo;

@Controller
public class StudentController {

	@Autowired
	StudentService service;
	
	@RequestMapping("/stu/query")
	public String sel(Model model,Integer pageNum){
		model.addAttribute("stus", service.select(null, pageNum, 5));
		return "find";
	}

	@RequestMapping("/stu/update")
	public String update(Model model,Integer id){
		model.addAttribute("stu",service.selectByPrimaryKey(id));
		return "update";
	}

	/*@RequestMapping("stu/udpates")
	public String updates(Integer id,String name,Integer age){
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		service.updateByPrimaryKey(stu);
		return "redirect:querys?pageNum=1";
	}

	@RequestMapping("stu/delete")
	public String delete(Integer id){
		service.delete(id);
		return "redirect:querys?pageNum=1";
	}*/
}
