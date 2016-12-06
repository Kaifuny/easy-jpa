package com.sbiger.service;

import com.sbiger.entity.User;
import com.sbiger.qbe.Example;
import com.sbiger.reponsitory.UserReponsitory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sbiger on 2016-11-25.
 */
@Service
public class UserService {
    @Resource
    UserReponsitory userReponsitory;

    public List<User> findAll(){
        Example<User> example = new Example<User>();
        example.or().andNotEqual("id","1");
        return userReponsitory.findAll(example);
    }
}
