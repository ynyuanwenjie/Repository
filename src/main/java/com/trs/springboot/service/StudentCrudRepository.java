package com.trs.springboot.service;

import com.trs.springboot.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yuanwenjie on 2016/11/26.
 */
public interface StudentCrudRepository extends CrudRepository<Student,Integer> {
}
