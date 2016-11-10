package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.*;


/**
 * Created by shoyu666 on 2016/11/9.
 */

public abstract class BaseAdapter extends ClassVisitor {
    public static final String DescFindViewAnnoe = "Lcom/shoyu666/findviewlib/BindView;";
    public static final String DescView = "Landroid/view/View;";

    BaseAdapter(int api) {
        super(api)
    }

    BaseAdapter(int api, ClassVisitor cv) {
        super(api, cv)
    }

    public void hook(AnnoedClassInfo info) {
        MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC, "likeButterKnife", "(" + DescView + ")V", null, null);
        mv.visitCode();
        info.annoedFileds.each {
            putFindViewOpt(mv, it, info.ower);
        }
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    /**
     * @param info
     * @param ower
     */
    public void putFindViewOpt(MethodVisitor mv, FiledInfo info, String ower) {
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitLdcInsn(info.resId)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "android/view/View", "findViewById", "(I)" + DescView, false);
        mv.visitTypeInsn(Opcodes.CHECKCAST, info.desc.substring(1, info.desc.length() - 1));
        mv.visitFieldInsn(Opcodes.PUTFIELD, ower, info.name, info.desc);
    }
}
