package net.dryanhild.gradle.oscrosscompiler.config

/**
 * Created by dhild on 11/3/14.
 */
class GmpConfigExtension implements ToolSource, Serializable {

    final String name = 'gmp'

    String version = '6.0.0'
    String compression = '.tar.bz2'

    String downloadUrl = "https://gmplib.org/download/gmp/gmp-${version}.tar.bz2"
}
