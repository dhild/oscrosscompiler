package net.dryanhild.gradle.oscrosscompiler.config

/**
 * Created by dhild on 11/3/14.
 */
class MpcConfigExtension implements ToolSource {

    final String name = 'mpc'

    String version = '1.0.2'
    String compression = '.tar.gz'

    String downloadUrl = "ftp://ftp.gnu.org/gnu/mpc/mpc-${version}.tar.gz"
}
