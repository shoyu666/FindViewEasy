package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Opcodes

/**
 * Created by shoyu666 on 2016/11/9.
 */

public class FindViewFiledVisitor extends FieldVisitor {

    AnnoedClassInfo clazzInfo;
    FiledInfo fieldInfo;

    public FindViewFiledVisitor(int api) {
        super(api);
    }

    public FindViewFiledVisitor(int api, FieldVisitor fv, AnnoedClassInfo clazzInfo, FiledInfo fieldInfo) {
        super(api, fv);
        this.clazzInfo = clazzInfo;
        this.fieldInfo = fieldInfo;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        L.d(desc)
        if (BaseAdapter.DescFindViewAnnoe.equals(desc)) {
            if (clazzInfo == null) {
                throw new RuntimeException("clazzInfo can not be null")
            }
            clazzInfo.addAnnoedFiled(fieldInfo);
            AnnotationVisitor before = super.visitAnnotation(desc, visible)
            System.out.println("###############################"+fieldInfo)
            FindViewAnnotationVisitor newSaveStateAnnotationVisitor = new FindViewAnnotationVisitor(Opcodes.ASM4,before,fieldInfo);
            return newSaveStateAnnotationVisitor;
        } else {
            return super.visitAnnotation(desc, visible);
        }

    }
}
