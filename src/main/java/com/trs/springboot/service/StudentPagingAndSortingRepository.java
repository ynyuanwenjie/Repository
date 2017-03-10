package com.trs.springboot.service;

import com.trs.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by yuanwenjie on 2016/11/26.
 */
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student,Integer>{

    Page<Student> findByAge(int age, Pageable pageable);

    List<Student> findByAge(int age, Sort sort);
}
