package com.qijia.framework.dao;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * 继承 路线
 * MyPage --> Page<T> --> Pagination --> RowBounds implements Serializable {
 * Created by weichen on 2018/9/28.
 */
public class MyPage<T> extends Page<T>{
}
