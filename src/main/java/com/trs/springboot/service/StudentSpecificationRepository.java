package com.trs.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by yuanwenjie on 2017/2/28.
 */
public class StudentSpecificationRepository implements JpaSpecificationExecutor {
    @Override
    public Object findOne(Specification specification) {
        return null;
    }

    @Override
    public List findAll(Specification specification) {
        return null;
    }

    @Override
    public Page findAll(Specification specification, Pageable pageable) {
        return null;
    }

    @Override
    public List findAll(Specification specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification specification) {
        return 0;
    }
}
