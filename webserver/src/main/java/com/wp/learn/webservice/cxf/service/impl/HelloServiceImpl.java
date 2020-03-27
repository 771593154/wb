/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.wp.learn.webservice.cxf.service.impl;

import com.wp.learn.webservice.cxf.service.HelloService;

import javax.jws.WebService;


@WebService(endpointInterface = "com.wp.learn.webservice.cxf.service.HelloService", serviceName = "hello")

public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "hi," + name;
    }
}
