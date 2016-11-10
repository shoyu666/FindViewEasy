package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes;

/**
 * Created by shoyu666 on 2016/11/10
 */

public class FindViewMethodVisitor extends MethodVisitor{
    AnnoedClassInfo clazzInfo;
    MethodInfo methodInfo;
    FindViewMethodVisitor(int api) {
        super(api)
    }

    FindViewMethodVisitor(int api, MethodVisitor mv,AnnoedClassInfo clazzInfo,MethodInfo methodInfo) {
        super(api, mv)
        this.clazzInfo=clazzInfo;
        this.methodInfo= methodInfo;
    }

    @Override
    AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        L.d(desc)
        if (BaseAdapter.DescOnClickMethodAnnoe.equals(desc)) {
            if (clazzInfo == null) {
                throw new RuntimeException("clazzInfo can not be null")
            }
            clazzInfo.setOnClickMethod(methodInfo);
            AnnotationVisitor before = super.visitAnnotation(desc, visible)
            FindViewMethodAnnotationVisitor newSaveStateAnnotationVisitor = new FindViewMethodAnnotationVisitor(Opcodes.ASM4,before,methodInfo);
            return newSaveStateAnnotationVisitor;
        } else {
            return super.visitAnnotation(desc, visible);
        }
    }
}
