package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.AnnotationVisitor


/**
 * Created by shoyu666 on 2016/11/9.
 */

public class FindViewAnnotationVisitor extends AnnotationVisitor {
    FiledInfo fieldInfo;

    FindViewAnnotationVisitor(int i) {
        super(i)
    }

    public FindViewAnnotationVisitor(int i, AnnotationVisitor annotationVisitor, FiledInfo fieldInfo) {
        super(i, annotationVisitor)
        this.fieldInfo = fieldInfo;
    }

    @Override
    void visit(String s, Object o) {
        L.d(s + o);
        if ("value".equals(s) && o instanceof Integer) {
            fieldInfo.resId = (Integer) o;
        }
        super.visit(s, o)
    }
}
