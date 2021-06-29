package com.sctbc.Service;

import com.sctbc.Dao.TimetableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableServer {
    @Autowired
    private TimetableMapper templateMapper;
}
