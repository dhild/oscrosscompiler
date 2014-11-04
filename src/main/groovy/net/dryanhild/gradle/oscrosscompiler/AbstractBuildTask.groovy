package net.dryanhild.gradle.oscrosscompiler

import net.dryanhild.gradle.oscrosscompiler.config.CrossCompilerExtension
import net.dryanhild.gradle.oscrosscompiler.config.ToolSource
import org.gradle.api.DefaultTask
import org.gradle.api.Project

/**
 * Created by dhild on 11/4/14.
 */
abstract class AbstractBuildTask extends DefaultTask {

    final String buildBase = "${project.buildDir.path}/crosscompiler/build"
    final String prefix = "${project.buildDir.path}/crosscompiler/compiler"
    final String bin = "${prefix}/bin"

    abstract String getName()
    abstract String getSourceFile()

    def extractSource() {
        project.copy {
            if (sourceFile.endsWith(".tar.bz2")) {
                from(tarTree(resources.bzip2(sourceFile)))
            } else if (sourceFile.endsWith(".tar.gz")) {
                from(tarTree(resources.gzip(sourceFile)))
            }
            into "$buildBase"
        }
    }

    CrossCompilerExtension getConfig() {
        project.extensions.findByType(CrossCompilerExtension)
    }

    static File getFileFor(Project project, ToolSource source) {
        DownloadCompilerSourcesTask.getFileFor(project, source)
    }

    String getCrossBuildDir() {
        "${name}-build"
    }

}
