/*
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

import de.flapdoodle.embed.mongo.packageresolver.Command;
import de.flapdoodle.embed.mongo.packageresolver.HtmlParserResultTester;
import de.flapdoodle.embed.process.distribution.Distribution;
import de.flapdoodle.embed.process.distribution.Version;
import de.flapdoodle.os.*;
import de.flapdoodle.os.linux.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinuxPackageFinderTest {

  /*
    Linux (legacy) undefined
    https://fastdl.mongodb.org/linux/mongodb-linux-i686-{}.tgz
    3.2.0 -> 3.2.22, 3.0.0 -> 3.0.15, 2.6.0 -> 2.6.12
  */
  @ParameterizedTest
  @ValueSource(strings = {"3.2.0 -> 3.2.22", " 3.0.0 -> 3.0.15", " 2.6.0 -> 2.6.12"})
  public void legacy32Bit(String version) {
    assertThat(linuxWith(CommonArchitecture.X86_32), version)
            .resolvesTo("/linux/mongodb-linux-i686-{}.tgz");
  }

  /*
    Linux (legacy) x64
    https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-{}.tgz
    4.0.0 -> 4.0.28, 3.6.0 -> 3.6.23, 3.4.9 -> 3.4.24, 3.4.0 -> 3.4.7, 3.2.0 -> 3.2.22, 3.0.0 -> 3.0.15, 2.6.0 -> 2.6.12
  */
  @ParameterizedTest
  @ValueSource(strings = {"4.0.0 -> 4.0.28", " 3.6.0 -> 3.6.23", " 3.4.9 -> 3.4.24", " 3.4.0 -> 3.4.7", " 3.2.0 -> 3.2.22", " 3.0.0 -> 3.0.15", " 2.6.0 -> 2.6.12"})
  public void  legacy64Bit(String version) {
    assertThat(linuxWith(CommonArchitecture.X86_64), version)
            .resolvesTo("/linux/mongodb-linux-x86_64-{}.tgz");
  }

  @Test
  public void resolveRedhatPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
            .withVersion(RedhatVersion.Redhat_7), "5.0.2")
            .resolvesTo("/linux/mongodb-linux-x86_64-rhel70-{}.tgz");
  }

  @Test
  public void resolveOraclePackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withDistribution(LinuxDistribution.Oracle)
            .withVersion(OracleVersion.Oracle_6), "4.4.9")
            .resolvesTo("/linux/mongodb-linux-x86_64-rhel62-{}.tgz");
  }

  @Test
  public void resolveCentosPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(CentosVersion.CentOS_8), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-rhel80-{}.tgz");
  }

  @Test
  public void resolveDebianPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(DebianVersion.DEBIAN_9), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-debian92-{}.tgz");
  }

  @Test
  public void resolveUbuntuForDebianPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(DebianVersion.DEBIAN_12), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-ubuntu2004-{}.tgz");
  }

  @Test
  public void resolveUbuntuPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(UbuntuVersion.Ubuntu_20_10), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-ubuntu2004-{}.tgz");
  }

  @Test
  public void resolveLinuxMintPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(LinuxMintVersion.LINUX_MINT_19_0), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-ubuntu1804-{}.tgz");
  }

  @Test
  public void resolvePopOSPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(PopOSVersion.POP_OS_22_4), "6.0.4")
      .resolvesTo("/linux/mongodb-linux-x86_64-ubuntu2204-{}.tgz");
  }

  @Test
  public void resolveAmazonPackageFromSample() {
    assertThat(linuxWith(CommonArchitecture.X86_64)
      .withVersion(AmazonVersion.AmazonLinux2), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-amazon2-{}.tgz");
  }

  @Test
  public void resolveFallbackPackage() {
    assertThat(linuxWith(CommonArchitecture.X86_64), "5.0.2")
      .resolvesTo("/linux/mongodb-linux-x86_64-ubuntu2004-{}.tgz");
  }

  private static ImmutablePlatform linuxWith(CommonArchitecture architecture) {
    return ImmutablePlatform.builder()
            .operatingSystem(CommonOS.Linux)
            .architecture(architecture)
            .build();
  }

  private static HtmlParserResultTester assertThat(Platform platform, String versionList) {
    return HtmlParserResultTester.with(
            new LinuxPackageFinder(Command.Mongo),
            version -> Distribution.of(Version.of(version), platform),
            versionList);
  }

}