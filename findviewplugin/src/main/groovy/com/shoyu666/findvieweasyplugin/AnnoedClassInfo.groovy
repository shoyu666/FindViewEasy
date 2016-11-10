package com.shoyu666.findvieweasyplugin;

/**
 *  record class info
 * Created by shoyu666 on 2016/11/9.
 */

public class AnnoedClassInfo {
    public String ower;
    public List<FiledInfo> annoedFileds;
    public boolean hasOSS = false;
    public File oldClazzFile;
    public MethodInfo onClickMethod;

    /**
     * set the ower class
     * @param ower
     * @return
     */
    public AnnoedClassInfo ower(String ower) {
        this.ower = ower;
        return this;
    }

    /**
     *  set OnClick method annoed  by OnClick
     * @param onClickMethod
     * @return
     */
    public AnnoedClassInfo setOnClickMethod(MethodInfo onClickMethod) {
        this.onClickMethod = onClickMethod;
        return this;
    }

    /**
     *  collection Filed  annoed  by BindView
     * @param filed
     * @return
     */
    public AnnoedClassInfo addAnnoedFiled(FiledInfo filed) {
        if (annoedFileds != null && filed != null) {
            if (annoedFileds.size() == 0) {
                L.d("find annoed file class " + oldClazzFile.getAbsolutePath())
            }
            annoedFileds.add(filed)
        } else {
            throw new RuntimeException("AnnoedClassInfo.annoedFileds or FiledInfo can not be null")
        }
        return this;
    }

    public AnnoedClassInfo fileds(List<FiledInfo> fileds) {
        this.annoedFileds = fileds;
        return this;
    }

    public AnnoedClassInfo hasOSS(boolean hasOSS) {
        this.hasOSS = hasOSS;
        return this;
    }

    public AnnoedClassInfo oldClazzFile(File oldClazzFile) {
        this.oldClazzFile = oldClazzFile;
        return this;
    }
}
