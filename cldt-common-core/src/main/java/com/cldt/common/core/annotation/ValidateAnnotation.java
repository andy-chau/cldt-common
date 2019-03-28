package com.cldt.common.core.annotation;

import java.lang.annotation.*;

/**
 * The interface Validate annotation.
 *
 * @author cldt
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateAnnotation {
	/**
	 * Is validate boolean.
	 *
	 * @return the boolean
	 */
	boolean isValidate() default true;
}