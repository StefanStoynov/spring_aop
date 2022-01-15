package com.ss.spring_aop.data;

import com.ss.spring_aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    //Custom annotation defined in interface TrackTime
    @TrackTime
    public String retrieveSomething(){
        return "dao1";
    }
}
