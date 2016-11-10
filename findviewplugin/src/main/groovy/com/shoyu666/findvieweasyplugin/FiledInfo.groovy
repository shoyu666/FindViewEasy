package com.shoyu666.findvieweasyplugin;

/**
 * Created by shoyu666 on 2016/11/9.
 */
public class FiledInfo {
    public int access;
    public String name;
    public String desc;
    public String signature;
    public Object value;
    public int resId;
    public boolean annoed = false;

    public FiledInfo annoed(boolean annoed) {
        this.annoed = annoed;
        return this;
    }

    public class Builder {
        public int access;
        public String name;
        public String desc;
        public String signature;
        public Object value;
        public int resId;

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }
        public Builder access(int access) {
            this.access = access;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder signature(String signature) {
            this.signature = signature;
            return this;
        }

        public Builder value(Object value) {
            this.value = value;
            return this;
        }

        public Builder resId(int resId) {
            this.resId = resId;
            return this;
        }

        public FiledInfo build() {
            FiledInfo info = new FiledInfo();
            info.access = this.access;
            info.name = this.name;
            info.desc = this.desc;
            info.signature = this.signature;
            info.value = this.value;
            info.resId = this.resId;
            return info;
        }
    }
}
