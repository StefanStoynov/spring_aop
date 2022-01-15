package com.ss.spring_aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
    public String retrieveSomething(){
        return "dao2";
    }
}
