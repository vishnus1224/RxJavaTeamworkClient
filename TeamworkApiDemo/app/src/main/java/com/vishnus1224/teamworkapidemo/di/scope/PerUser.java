package com.vishnus1224.teamworkapidemo.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Custom scope for user level dependencies.
 * Created by Vishnu on 8/14/2016.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerUser {
}
