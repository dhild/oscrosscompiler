package net.dryanhild.gradle.oscrosscompiler.config
/**
 * Created by dhild on 11/3/14.
 */
class CrossCompilerExtension implements Serializable {

    String target = "x86_64-elf"

    BinutilsConfigExtension binutils = new BinutilsConfigExtension()
    GccConfigExtension gcc = new GccConfigExtension()
}
