/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * with contributions from
 * 	konstantin-ba@github,Archimedes Trajano	(trajano@github)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embed.mongo.packageresolver.linux;

import de.flapdoodle.embed.mongo.packageresolver.*;
import de.flapdoodle.embed.process.config.store.FileSet;
import de.flapdoodle.embed.process.config.store.FileType;
import de.flapdoodle.embed.process.config.store.Package;
import de.flapdoodle.embed.process.distribution.ArchiveType;
import de.flapdoodle.embed.process.distribution.Distribution;
import de.flapdoodle.os.BitSize;
import de.flapdoodle.os.CPUType;
import de.flapdoodle.os.CommonOS;
import de.flapdoodle.os.linux.*;
import de.flapdoodle.os.linux.DebianVersion;


import java.util.Optional;

/**
* this file is generated, please don't touch
*/
public class DebianPackageFinder extends AbstractPackageFinder {

  public DebianPackageFinder(final Command command) {
    super(command, rules(command));
  }

  private static FileSet fileSetOf(Command command) {
    return FileSet.builder()
            .addEntry(FileType.Executable, command.commandName())
            .build();
  }

  private static ImmutablePackageFinderRules rules(final Command command) {
    FileSet fileSet = fileSetOf(command);

    PackageFinderRule devRule_DEBIAN_11_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("7.0.0-rc8"),
                  VersionRange.of("7.0.0-rc2"),
                  VersionRange.of("7.0.0-rc10"),
                  VersionRange.of("7.0.0-rc1"),
                  VersionRange.of("6.3.1", "6.3.2"),
                  VersionRange.of("6.0.9-rc1"),
                  VersionRange.of("5.0.20-rc1"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian11-{version}.tgz")
            .isDevVersion(true)
            .build())
        .build();

    PackageFinderRule rule_DEBIAN_11_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("6.0.8"),
                  VersionRange.of("6.0.1", "6.0.6"),
                  VersionRange.of("5.0.18", "5.0.19"),
                  VersionRange.of("5.0.12", "5.0.15"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian11-{version}.tgz")
            .build())
        .build();

 
    PackageFinderRule tools_DEBIAN_11_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  ToolVersionRange.of("100.7.0", "100.7.4"),
                  ToolVersionRange.of("100.6.0", "100.6.1"),
                  ToolVersionRange.of("100.5.3", "100.5.4"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/tools/db/mongodb-database-tools-debian11-x86_64-{tools.version}.tgz")
            .build())
        .build();


    PackageFinderRule devRule_DEBIAN_10_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("7.0.0-rc2"),
                  VersionRange.of("7.0.0-rc1"),
                  VersionRange.of("6.3.1", "6.3.2"),
                  VersionRange.of("6.0.9-rc1"),
                  VersionRange.of("5.0.20-rc1"),
                  VersionRange.of("4.4.24-rc0"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian10-{version}.tgz")
            .isDevVersion(true)
            .build())
        .build();

    PackageFinderRule rule_DEBIAN_10_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("6.0.8"),
                  VersionRange.of("6.0.1", "6.0.6"),
                  VersionRange.of("5.0.18", "5.0.19"),
                  VersionRange.of("5.0.12", "5.0.15"),
                  VersionRange.of("5.0.5", "5.0.6"),
                  VersionRange.of("5.0.0", "5.0.2"),
                  VersionRange.of("4.4.22", "4.4.23"),
                  VersionRange.of("4.4.16", "4.4.19"),
                  VersionRange.of("4.4.13"),
                  VersionRange.of("4.4.11"),
                  VersionRange.of("4.4.0", "4.4.9"),
                  VersionRange.of("4.2.22", "4.2.24"),
                  VersionRange.of("4.2.18", "4.2.19"),
                  VersionRange.of("4.2.5", "4.2.16"),
                  VersionRange.of("4.2.1", "4.2.3"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian10-{version}.tgz")
            .build())
        .build();

 
    PackageFinderRule tools_DEBIAN_10_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  ToolVersionRange.of("100.7.0", "100.7.4"),
                  ToolVersionRange.of("100.6.0", "100.6.1"),
                  ToolVersionRange.of("100.5.0", "100.5.4"),
                  ToolVersionRange.of("100.4.0", "100.4.1"),
                  ToolVersionRange.of("100.3.0", "100.3.1"),
                  ToolVersionRange.of("100.2.0", "100.2.1"),
                  ToolVersionRange.of("100.1.0", "100.1.1"),
                  ToolVersionRange.of("100.0.0", "100.0.2"),
                  ToolVersionRange.of("99.0.0"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/tools/db/mongodb-database-tools-debian10-x86_64-{tools.version}.tgz")
            .build())
        .build();


    PackageFinderRule devRule_DEBIAN_9_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_9, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("5.0.20-rc1"),
                  VersionRange.of("4.4.24-rc0"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian92-{version}.tgz")
            .isDevVersion(true)
            .build())
        .build();

    PackageFinderRule rule_DEBIAN_9_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_9, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  VersionRange.of("5.0.18", "5.0.19"),
                  VersionRange.of("5.0.12", "5.0.15"),
                  VersionRange.of("5.0.5", "5.0.6"),
                  VersionRange.of("5.0.0", "5.0.2"),
                  VersionRange.of("4.4.22", "4.4.23"),
                  VersionRange.of("4.4.16", "4.4.19"),
                  VersionRange.of("4.4.13"),
                  VersionRange.of("4.4.11"),
                  VersionRange.of("4.4.0", "4.4.9"),
                  VersionRange.of("4.2.22", "4.2.24"),
                  VersionRange.of("4.2.18", "4.2.19"),
                  VersionRange.of("4.2.5", "4.2.16"),
                  VersionRange.of("4.2.0", "4.2.3"),
                  VersionRange.of("4.0.0", "4.0.28"),
                  VersionRange.of("3.6.5", "3.6.23"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/linux/mongodb-linux-x86_64-debian92-{version}.tgz")
            .build())
        .build();

 
    PackageFinderRule tools_DEBIAN_9_X86_B64 = PackageFinderRule.builder()
        .match(match(CommonOS.Linux, BitSize.B64, CPUType.X86, DebianVersion.DEBIAN_9, DebianVersion.DEBIAN_10, DebianVersion.DEBIAN_11, DebianVersion.DEBIAN_12)
            .andThen(
                DistributionMatch.any(
                  ToolVersionRange.of("100.7.0", "100.7.4"),
                  ToolVersionRange.of("100.6.0", "100.6.1"),
                  ToolVersionRange.of("100.5.0", "100.5.4"),
                  ToolVersionRange.of("100.4.0", "100.4.1"),
                  ToolVersionRange.of("100.3.0", "100.3.1"),
                  ToolVersionRange.of("100.2.0", "100.2.1"),
                  ToolVersionRange.of("100.1.0", "100.1.1"),
                  ToolVersionRange.of("100.0.0", "100.0.2"),
                  ToolVersionRange.of("99.0.0"))
        ))
        .finder(UrlTemplatePackageFinder.builder()
            .fileSet(fileSet)
            .archiveType(ArchiveType.TGZ)
            .urlTemplate("/tools/db/mongodb-database-tools-debian92-x86_64-{tools.version}.tgz")
            .build())
        .build();


    switch (command) {
      case MongoDump:
      case MongoImport:
      case MongoRestore:
        return PackageFinderRules.empty()
            .withAdditionalRules(
                tools_DEBIAN_11_X86_B64
            )
            .withAdditionalRules(
                tools_DEBIAN_10_X86_B64
            )
            .withAdditionalRules(
                tools_DEBIAN_9_X86_B64
            )
            .withAdditionalRules(
                devRule_DEBIAN_10_X86_B64, rule_DEBIAN_10_X86_B64
            )
            .withAdditionalRules(
                devRule_DEBIAN_9_X86_B64, rule_DEBIAN_9_X86_B64
            );
      default:
        return PackageFinderRules.empty()
            .withAdditionalRules(
                devRule_DEBIAN_11_X86_B64, rule_DEBIAN_11_X86_B64
            ).withAdditionalRules(
                devRule_DEBIAN_10_X86_B64, rule_DEBIAN_10_X86_B64
            ).withAdditionalRules(
                devRule_DEBIAN_9_X86_B64, rule_DEBIAN_9_X86_B64
            );
    }
  }
}