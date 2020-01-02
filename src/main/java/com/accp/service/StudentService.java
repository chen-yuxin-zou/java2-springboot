package com.accp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Student;
import com.accp.domain.StudentExample;
import com.accp.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentMapper mapper;
	
	@Resource
	private RedisTemplate redisTemplate;
	
	public PageInfo<Student> select(StudentExample example,Integer pageNum,Integer pageSize){
		Page page = PageHelper.startPage(pageNum, pageSize);
		mapper.selectByExample(example);
		return page.toPageInfo();
	}
	
	public Integer insert(Student record) {
		return mapper.insert(record);
	}
	
	public Integer deleteByPrimaryKey(Integer id) {
		Integer ret = mapper.deleteByPrimaryKey(id);
		String key = "stu_"+id;
		boolean haskey = redisTemplate.hasKey(key);
		if (haskey){
			redisTemplate.delete(key);
		}
		return ret;
	}

	public Integer update(Student record){
		Integer ret = mapper.updateByPrimaryKey(record);
		String key = "stu_"+record.getId();
		boolean haskey = redisTemplate.hasKey(key);
		if (haskey){
			redisTemplate.delete(key);
		}
		return ret;
	}

	public Student selectByPrimaryKey(Integer id){
		String key = "stu_"+id;
		ValueOperations<String,Student> operations = redisTemplate.opsForValue();
		boolean haskey = redisTemplate.hasKey(key);
		if (haskey){
			Student stu = operations.get(key);
			return stu;
		}
		Student stu = mapper.selectByPrimaryKey(id);
		operations.set(key,stu,10, TimeUnit.SECONDS);
		return stu;
	}
}
