package com.github.jioong.basic.spring.in.action.aop.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by jioong on 17-3-27.
 */

@Aspect
public class EncorableIntroducer {

    @DeclareParents(value = "com.github.jioong.basic.spring.in.action.aop.Performance+", defaultImpl = DefaultEncorable.class)
    public static Encoreable encoreable;
}
