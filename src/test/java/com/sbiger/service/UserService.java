package com.sbiger.service;

import com.sbiger.entity.User;
import com.sbiger.qbe.Example;
import com.sbiger.reponsitory.UserReponsitory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sbiger on 2016-11-25.
 */
@Service
public class UserService {
    @Resource
    UserReponsitory userReponsitory;

    public Page<User> findAll(){
        Example<User> example = new Example<User>();

        example.or()
                .andEqual("id", 1)
                .orEqual("id", 2);

        example.asc("id","name");
        return userReponsitory.findAll(example, new PageRequest(0, 1));
    }
}
