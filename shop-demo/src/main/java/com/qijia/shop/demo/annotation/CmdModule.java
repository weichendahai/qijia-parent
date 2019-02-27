package com.qijia.shop.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by weichen on 2018/8/11.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//@Inherited
public @interface CmdModule {
	String value();
}
