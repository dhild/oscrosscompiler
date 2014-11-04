package net.dryanhild.gradle.oscrosscompiler

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by dhild on 11/3/14.
 */
class OSCompilerPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('crossCompiler', CrossCompilerExtension)
    }
}
