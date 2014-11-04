package net.dryanhild.gradle.oscrosscompiler

import net.dryanhild.gradle.oscrosscompiler.config.CrossCompilerExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by dhild on 11/3/14.
 */
class OSCompilerPlugin implements Plugin<Project> {
    public static final String CROSS_COMPILER_EXTENSION = 'crossCompiler'

    @Override
    void apply(Project project) {
        project.extensions.create(CROSS_COMPILER_EXTENSION, CrossCompilerExtension)
    }
}
