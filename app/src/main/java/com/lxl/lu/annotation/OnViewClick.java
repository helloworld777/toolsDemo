package com.lxl.lu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@EventBase(listenerType=View.OnViewClickListener.class,listenerSetter="setOnClickIntent",methodName = "onViewClick")
public @interface OnViewClick {
	int[] value();
}
