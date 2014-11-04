package net.dryanhild.gradle.oscrosscompiler.config
/**
 * Created by dhild on 11/3/14.
 */
class BinutilsConfigExtension implements ToolSource {

    final String name = 'binutils'

    String version = '2.24'
    String compression = '.tar.bz2'

    String downloadUrl = "ftp://ftp.gnu.org/gnu/binutils/binutils-${version}.tar.bz2"

}
