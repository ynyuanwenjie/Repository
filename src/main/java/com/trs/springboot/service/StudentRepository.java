package com.trs.springboot.service;

import com.trs.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * Created by konghao on 2016/11/23.
 */
public interface StudentRepository extends Repository<Student,Integer> {

    @Query("select s from Student s where s.id=?1")
    public Student loadById(int id);

    //根据地址和年龄进行查询
    List<Student> findByAddressAndAge(String address, int age);
    //根据id获取对象，即可返回对象，也可以返回列表
    Student readById(int id);

    List<Student> getById(int id);

    Student findById(int id);

    List<Student> findByAge(int age);

    List<Student> findDistinctByAge(int age);

    /**
     * 区分大小写
     * @param address
     * @return
     */
    List<Student> findByAddress(String address);

    /**
     * 忽略大小写
     * @param address
     * @return
     */
    List<Student> findByAddressIgnoreCase(String address);

    /**
     * 排序
     * @param address
     * @return
     */
    List<Student> findByAddressOrderByAgeDesc(String address);

    /**
     * 分页
     * @param lastname
     * @param pageable
     * @return
     */
    //Page<Student> findByAddress(String address, Pageable pageable);

    /**
     * 切片
     * @param lastname
     * @param pageable
     * @return
     */
    //Slice<Student> findByAddress(String address, Pageable pageable);

    /**
     * 排序
     * @param address
     * @return
     */
    List<Student> findByAddress(String address, Sort sort);

    /**
     * 分页
     * @param address
     * @param pageable
     * @return
     */
    List<Student> findByAddress(String address, Pageable pageable);

    Slice<Student> findTop3ByAddress(String address, Pageable pageable);

    List<Student> findFirst10ByAddress(String address, Sort sort);


    /**
     * Streaming query results
     */
    @Query("select s from Student s")
    Stream<Student> findByQuery();

    /**
     * Async query results
     */
    Future<Student> findByName(String name);
}