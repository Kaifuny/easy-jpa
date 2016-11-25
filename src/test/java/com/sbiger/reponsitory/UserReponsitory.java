package com.sbiger.reponsitory;

import com.sbiger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.io.Serializable;

/**
 * Created by sbiger on 2016/11/4
 */
public interface UserReponsitory extends JpaRepository<User, Serializable> , JpaSpecificationExecutor<User> {}
