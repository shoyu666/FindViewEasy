package com.shoyu666.findviewlib;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by shoyu666 on 2016/11/10.
 */

public class ButterKnife {
    public static void bind(Activity target) {
        View sourceView = target.getWindow().getDecorView();
        bind(target, sourceView);
    }

    public static void bind(@NonNull Object target, @NonNull View source) {
        try {
            target.getClass().getMethod("likeButterKnife", View.class).invoke(target, source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
