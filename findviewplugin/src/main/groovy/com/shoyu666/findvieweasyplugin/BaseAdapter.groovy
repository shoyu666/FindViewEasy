package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.*;


/**
 * Created by shoyu666 on 2016/11/9.
 */

public abstract class BaseAdapter extends ClassVisitor {
    public static final String DescFindViewAnnoe = "Lcom/shoyu666/findviewlib/BindView;";
    public static final String DescOnClickMethodAnnoe = "Lcom/shoyu666/findviewlib/OnClick;";
    public static final String DescView = "Landroid/view/View;";
    public static final String View="android/view/View";
    public static final String FindViewById="findViewById";
    public static final String SetOnClickListener="setOnClickListener";

    BaseAdapter(int api) {
        super(api)
    }

    BaseAdapter(int api, ClassVisitor cv) {
        super(api, cv)
    }

    /**
     * process
     * @param info
     */
    public void process(AnnoedClassInfo info) {
        MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC, "likeButterKnife", "(" + DescView + ")V", null, null);
        mv.visitCode();
        if (info.annoedFileds != null && info.annoedFileds.size() > 0) {
            info.annoedFileds.each {
                putFindViewOpt(mv, it, info.ower);
            }
        }
        if (info.onClickMethod != null && info.onClickMethod.resIds != null && info.onClickMethod.resIds.length> 0) {
            info.onClickMethod.resIds.each {
                bindOnClickOpt(mv, it)
            }
        }else{
            L.d("ignore onclick")
        }
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }
    /**
     *  add  findviewById
     * @param mv
     * @param info
     * @param ower
     */
    public void putFindViewOpt(MethodVisitor mv, FiledInfo info, String ower) {
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitLdcInsn(info.resId)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,View, "findViewById", "(I)" + DescView, false);
        mv.visitTypeInsn(Opcodes.CHECKCAST, info.desc.substring(1, info.desc.length() - 1));
        mv.visitFieldInsn(Opcodes.PUTFIELD, ower, info.name, info.desc);
    }

    /**
     * bind onClick
     * @param mv
     * @param info
     * @param ower
     */
    public void bindOnClickOpt(MethodVisitor mv, int resId) {
        L.d("bindOnClickOpt")
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitLdcInsn(resId)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,View, FindViewById, "(I)" + DescView, false);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,View,SetOnClickListener,"(Landroid/view/View\$OnClickListener;)V", false);
    }
}
