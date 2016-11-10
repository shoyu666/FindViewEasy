package com.shoyu666.findvieweasyplugin;

/**
 * Created by shoyu666 on 2016/11/10 0010.
 */

public class MethodInfo {
    int access;
    String name;
    String desc;
    String signature;
    String[] exceptions;
    public int[] resIds;

    public class Builder {
        int access;
        String name;
        String desc;
        String signature;
        String[] exceptions;

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

        public Builder exceptions(String[] exceptions) {
            this.exceptions = exceptions;
            return this;
        }

        public MethodInfo build() {
            MethodInfo info = new MethodInfo();
            info.access = this.access;
            info.name = this.name;
            info.desc = this.desc;
            info.signature = this.signature;
            info.exceptions = this.exceptions;
            return info;
        }
    }
}
