package com.shoyu666.findvieweasyplugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by shoyu666 on 2016/11/9.
 */
class FindViewPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        def isApp = project.plugins.hasPlugin(AppPlugin)
        if (isApp) {
            L.d("FindViewPlugin init")
            def android = project.extensions.getByType(AppExtension)
            def transform = new FindViewTransform()
            android.registerTransform(transform)
        }
    }
}
