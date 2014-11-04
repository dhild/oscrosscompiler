package net.dryanhild.gradle.oscrosscompiler

/**
 * Created by dhild on 11/3/14.
 */
class GccConfigExtension {

    String version = '4.92'

    String downloadUrl = "ftp://ftp.gnu.org/gnu/gcc/gcc-${version}/gcc-${version}.tar.bz2"

    GmpConfigExtension gmp = new GmpConfigExtension()
    MpfrConfigExtension mpfr = new MpfrConfigExtension()
    MpcConfigExtension mpc = new MpcConfigExtension()
}
