package net.dryanhild.gradle.oscrosscompiler.config

/**
 * Created by dhild on 11/3/14.
 */
interface ToolSource {

    String getName();

    String getVersion();

    String getCompression();

    String getDownloadUrl();
}
