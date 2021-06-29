package com.sctbc.Service;

import com.sctbc.Dao.Home_moneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Home_moneyServer {
    @Autowired
    private Home_moneyMapper home_moneyMapper;
}
