package net.dryanhild.gradle.oscrosscompiler

import org.gradle.api.tasks.TaskAction

/**
 * Created by dhild on 11/4/14.
 */
class BinutilsBuildTask extends AbstractBuildTask {
    @Override
    String getName() {
        config.binutils.name
    }

    @Override
    String getSourceFile() {
        getFileFor(project, config.binutils).path
    }

    @TaskAction
    def build() {
        extractSource()
        project.mkdir(crossBuildDir)
        project.exec {
            workingDir "crossBuildDir"
            commandLine "../${name}-${config.binutils.version}/configure", "--target=${config.target}", "--prefix=${prefix}", '--with-sysroot', '--disable-nls', '--disable-werror'
        }
        project.exec {
            workingDir "crossBuildDir"
            commandLine 'make'
        }
        project.exec {
            workingDir "crossBuildDir"
            commandLine 'make', 'install'
        }
    }

}
