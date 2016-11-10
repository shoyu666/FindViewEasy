package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes;

/**
 * Created by shoyu666 on 2016/11/9.
 */

public class ClazzVisitor extends BaseAdapter {
    AnnoedClassInfo info;

    public ClazzVisitor(int api) {
        super(api);
    }

    public ClazzVisitor(int api, ClassVisitor cv, AnnoedClassInfo info) {
        super(api, cv);
        this.info = info;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        FieldVisitor before = super.visitField(access, name, desc, signature, value)
        FiledInfo fieldInfo = new FiledInfo.Builder().access(access).name(name).desc(desc).signature(signature).value(value).build();
        FindViewFiledVisitor newSaveStateFiledVisitor = new FindViewFiledVisitor(Opcodes.ASM4, before, info, fieldInfo);
        return newSaveStateFiledVisitor;
    }

    @Override
    public void visitEnd() {
        if (info != null && info.annoedFileds.size() > 0) {
            hook(info);
        }
        super.visitEnd();
    }
}
