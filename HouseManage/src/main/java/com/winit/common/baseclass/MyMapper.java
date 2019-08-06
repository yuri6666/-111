package com.winit.common.baseclass;

import tk.mybatis.mapper.common.MySqlMapper;

/**
 * MyMapper
 * 特别注意，该接口不能被扫描到，否则会出错
 */
public interface MyMapper<T> extends tk.mybatis.mapper.common.Mapper<T>, MySqlMapper<T> {
}
