package com.kent.algorithm.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.kent.algorithm.ui.DemoType;

/**
 * @author: Kent
 * Created on 2014-08-10.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo
{
	DemoType type() default DemoType.Problems;
	String name();
}
