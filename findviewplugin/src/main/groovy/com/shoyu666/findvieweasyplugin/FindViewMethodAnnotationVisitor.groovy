package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.AnnotationVisitor



/**
 * Created by shoyu666 on 2016/11/9.
 */

public class FindViewMethodAnnotationVisitor extends AnnotationVisitor {
    MethodInfo methodInfo;

    FindViewMethodAnnotationVisitor(int i) {
        super(i)
    }

    public FindViewMethodAnnotationVisitor(int i, AnnotationVisitor annotationVisitor, MethodInfo methodInfo) {
        super(i, annotationVisitor)
        this.methodInfo = methodInfo;
    }

    @Override
    void visit(String s, Object o) {
        L.d(s + o);
        if ("value".equals(s) && o instanceof int[]) {
            methodInfo.resIds = (int[]) o;
        }
        super.visit(s, o)
    }
}
