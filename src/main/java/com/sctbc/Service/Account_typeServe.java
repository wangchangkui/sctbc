package com.sctbc.Service;


import com.sctbc.Dao.Account_typeMapper;
import com.sctbc.Pojo.Account_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Account_typeServe {
    @Autowired
    private Account_typeMapper account_typeMapper;

    public List<Account_type> findAccType(){
        return account_typeMapper.findAccType();
    }
}
