/*
 * Copyright (c) 2018. cldt All Rights Reserved.
 * 类名称：MyMapper.java
 */

package com.cldt.common.core.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * The interface My mapper.
 *
 * @param <T> the type parameter cldt
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
