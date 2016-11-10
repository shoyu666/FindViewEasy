package com.shoyu666.findviewlib;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Retention(CLASS)
@Target(FIELD)
public @interface BindView {
    /**
     * View ID to which the field will be bound.
     */
    int value();
}
