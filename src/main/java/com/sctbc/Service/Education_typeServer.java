package com.sctbc.Service;

import com.sctbc.Dao.Education_typeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Education_typeServer {
    @Autowired
    private Education_typeMapper education_typeMapper;
}
