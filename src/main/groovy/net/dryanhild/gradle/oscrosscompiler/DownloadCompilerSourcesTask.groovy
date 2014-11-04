package net.dryanhild.gradle.oscrosscompiler

import net.dryanhild.gradle.oscrosscompiler.config.CrossCompilerExtension
import net.dryanhild.gradle.oscrosscompiler.config.ToolSource
import org.gradle.api.DefaultTask
import org.gradle.api.Project
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
            getFileFor(project, it)
        }
    }

    static File getFileFor(Project project, ToolSource source) {
        project.file(project.buildDir.path + "/crosscompiler/src/${source.name}/" +
                "${source.name}-${source.version}${source.compression}")
    }

    @TaskAction
    def downloadFiles() {
        getSources().each { ToolSource toolSource ->
            logger.info("Grabbing source for ${toolSource.name} from ${toolSource.downloadUrl}")
            ant.get(src: toolSource.downloadUrl, dest: getFileFor(project, toolSource))
        }
    }
}
