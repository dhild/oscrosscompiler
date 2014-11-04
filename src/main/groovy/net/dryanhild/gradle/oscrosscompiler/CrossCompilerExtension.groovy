package net.dryanhild.gradle.oscrosscompiler

/**
 * Created by dhild on 11/3/14.
 */
class CrossCompilerExtension {

    String gccVersion
    String targetPlatform

    BinutilsConfigExtension binutils = new BinutilsConfigExtension()
    GccConfigExtension gcc = new GccConfigExtension()
}
