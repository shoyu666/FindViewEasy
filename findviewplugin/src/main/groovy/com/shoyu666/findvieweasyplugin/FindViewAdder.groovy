package com.shoyu666.findvieweasyplugin

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes;

/**
 * Created by shoyu666 on 2016/11/8.
 */
/**
 * Created by shoyu666 on 2016/11/9.
 */
public class FindViewAdder {

    public static byte[] hook(File oldClazzFile,String path) {
        AnnoedClassInfo info = new AnnoedClassInfo();
        String temp = path.split("\\.")[0];
        temp=temp.substring(1, temp.length());
        temp=temp.replace("\\","/")
        info.ower(temp)
        List<FiledInfo> result = new ArrayList<>();
        info.fileds(result);
        info.oldClazzFile(oldClazzFile);
        ClassReader cr = new ClassReader(info.oldClazzFile.bytes);
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClazzVisitor cv = new ClazzVisitor(Opcodes.ASM4, cw, info)
        cr.accept(cv, 0);
        return cw.toByteArray();
    }
}
