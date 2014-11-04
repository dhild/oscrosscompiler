package net.dryanhild.gradle.oscrosscompiler.config

/**
 * Created by dhild on 11/3/14.
 */
class MpfrConfigExtension implements ToolSource, Serializable {

    final String name = 'mpfr'

    String version = '3.1.2'
    String compression = '.tar.bz2'

    String downloadUrl = "http://www.mpfr.org/mpfr-${version}/mpfr-${version}.tar.bz2"
}
