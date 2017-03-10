package com.trs.springboot.start;

import com.trs.springboot.model.Student;
import com.trs.springboot.service.StudentCrudRepository;
import com.trs.springboot.service.StudentPagingAndSortingRepository;
import com.trs.springboot.service.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Created by yuanwenjie on 2016/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCrudRepository studentCrudRepository;
    @Autowired
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository;

   @Before
    public void before(){
        System.out.println("----------------------before--------------------------");
    }

    @After
    public void after(){
        System.out.println("----------------------end--------------------------");
    }
    @Test
    public void test01(){
        IntStream.range(1,100).forEach(s -> {
            Student student = new Student("foo"+s,"address"+s,s);
            studentCrudRepository.save(student);
        });
    }

    @Test
    public void test02() {
        Page<Student> lists = studentPagingAndSortingRepository.findAll(new PageRequest(0,10));
        lists.getContent().stream().forEach(s -> System.out.println(s.getName()));
    }

    @Test
    public void test04(){
        Student s = studentRepository.loadById(34);
        System.out.println(s);
    }

    @Test
    public void test05(){
        List<Student> students = studentRepository.findByAge(26);
        students.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test06() {
        List<Student> students = studentRepository.findDistinctByAge(26);
        students.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test07() {
        List<Student> students = studentRepository.findByAddressIgnoreCase("address26");
        students.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test08() {
        List<Student> students = studentRepository.findByAddress("address26");
        students.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test09() {
        List<Student> students = studentRepository.findByAddressOrderByAgeDesc("address");
        students.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test10() {
        studentRepository.findByQuery().forEach(s -> System.out.println(s));
    }

    public void test11() {
        Future<Student> students = studentRepository.findByName("foo");
    }

    @Test
    public void contextLoads(){

    }

    @Test
    public void testPageable01(){
        PageRequest pr = new PageRequest(1,5);
        Page<Student>  stus = studentPagingAndSortingRepository.findByAge(26,pr);
        System.out.println(stus.getSize());
        for(Student s:stus) {
            System.out.println(s);
        }
    }

    @Test
    public void testSort() {
        List<Student> students = studentPagingAndSortingRepository.findByAge(26,new Sort(Sort.Direction.DESC,"id"));
        System.out.println(students.size());
        for(Student student:students) {
            System.out.println(student);
        }
    }
}
