package com.mix.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class LegendCoder implements Plugin<Project> {
     @Override
     void apply(Project project) {
        def extension = target.extensions.create("legendcoder",LegendCoderExtension)
         target.afterEvaluate{
             println "Hello ${extension.name}"
         }
     }

}