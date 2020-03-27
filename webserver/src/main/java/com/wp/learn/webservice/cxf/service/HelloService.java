/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.wp.learn.webservice.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface HelloService {
    String sayHi(String name);
}
