package net.dryanhild.gradle.oscrosscompiler

import net.dryanhild.gradle.oscrosscompiler.config.CrossCompilerExtension
import net.dryanhild.gradle.oscrosscompiler.config.ToolSource
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFiles
import org.gradle.api.tasks.TaskAction

/**
 * Created by dhild on 11/3/14.
 */
class DownloadCompilerSourcesTask extends DefaultTask {

    @Input
    List<ToolSource> getSources() {
        CrossCompilerExtension config = project.extensions.findByType(CrossCompilerExtension)
        [
                config.binutils,
                config.gcc,
                config.gcc.gmp,
                config.gcc.mpc,
                config.gcc.mpfr,
        ]
    }

    @OutputFiles
    List<File> getOutputFiles() {
        getSources().collect {
            getFileFor(it)
        }
    }

    File getFileFor(ToolSource source) {
        project.file(project.buildDir + "/crosscompiler/src/${source.name}/" +
                "${source.name}-${source.version}${source.compression}")
    }

    @TaskAction
    def downloadFiles() {
        getSources().each { ToolSource toolSource ->
            ant.get(src: toolSource.downloadUrl, dest: getFileFor(toolSource))
        }
    }
}
