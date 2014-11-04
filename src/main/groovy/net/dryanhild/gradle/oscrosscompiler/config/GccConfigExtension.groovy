package net.dryanhild.gradle.oscrosscompiler.config

/**
 * Created by dhild on 11/3/14.
 */
class GccConfigExtension implements ToolSource, Serializable {

    final String name = 'gcc'

    String version = '4.9.2'
    String compression = '.tar.bz2'

    String downloadUrl = "ftp://ftp.gnu.org/gnu/gcc/gcc-${version}/gcc-${version}.tar.bz2"

    GmpConfigExtension gmp = new GmpConfigExtension()
    MpfrConfigExtension mpfr = new MpfrConfigExtension()
    MpcConfigExtension mpc = new MpcConfigExtension()
}
