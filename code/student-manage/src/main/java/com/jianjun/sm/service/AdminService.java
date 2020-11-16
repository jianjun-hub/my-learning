package com.jianjun.sm.service;

import com.jianjun.sm.entity.ResultEntity;

public interface AdminService {
    ResultEntity adminLogin(String account,String password);
}
