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

import de.flapdoodle.embed.mongo.packageresolver.Command;
import de.flapdoodle.embed.mongo.packageresolver.HtmlParserResultTester;
import de.flapdoodle.embed.process.distribution.Distribution;
import de.flapdoodle.embed.process.distribution.Version;
import de.flapdoodle.os.*;
import de.flapdoodle.os.linux.AmazonVersion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmazonPackageFinderTest {
	/*
	 * amazon2023 ARM 64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-aarch64-amazon2023-{}.tgz
	 * "7.0.0-rc8", "7.0.0-rc2"
	 */
	@ParameterizedTest
	@ValueSource(strings = {"7.0.0-rc8", "7.0.0-rc2"})
	public void amazon2023LinuxArm(String version) {
		assertThat(linuxWith(CommonArchitecture.ARM_64, AmazonVersion.AmazonLinux2023), version)
			.resolveDevPackageTo("/linux/mongodb-linux-aarch64-amazon2023-{}.tgz");
	}

	/*
	 * amazon2023 x64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon2023-{}.tgz
	 * "7.0.0-rc8", "7.0.0-rc2"
	 */
	@ParameterizedTest
	@ValueSource(strings = {"7.0.0-rc8", "7.0.0-rc2"})
	public void amazon2023Linux(String version) {
		assertThat(linuxWith(CommonArchitecture.X86_64, AmazonVersion.AmazonLinux2023), version)
			.resolveDevPackageTo("/linux/mongodb-linux-x86_64-amazon2023-{}.tgz");
	}

	/*
	 * Amazon Linux 2 ARM 64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-aarch64-amazon2-{}.tgz
   * 6.0.1 -> 6.0.6, 5.0.18, 5.0.12 -> 5.0.15, 5.0.5 -> 5.0.6, 5.0.0 -> 5.0.2, 4.4.22, 4.4.16 -> 4.4.19, 4.4.13, 4.4.11, 4.4.4 -> 4.4.9, 4.2.22 -> 4.2.24, 4.2.18 -> 4.2.19, 4.2.13 -> 4.2.16
	 */
	@ParameterizedTest
	@ValueSource(strings = {"6.0.8", "6.0.1 -> 6.0.6", "5.0.18 -> 5.0.19", "5.0.12 -> 5.0.15", "5.0.5 -> 5.0.6", "5.0.0 -> 5.0.2", "4.4.22 -> 4.4.23", "4.4.16 -> 4.4.19", "4.4.13", "4.4.11", "4.4.4 -> 4.4.9", "4.2.22 -> 4.2.24", "4.2.18 -> 4.2.19", "4.2.13 -> 4.2.16"})
	public void amazon2LinuxArm(String version) {
		assertThat(linuxWith(CommonArchitecture.ARM_64, AmazonVersion.AmazonLinux2), version)
			.resolvesTo("/linux/mongodb-linux-aarch64-amazon2-{}.tgz");
	}

	/*
	 * Amazon Linux 2 ARM 64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-aarch64-amazon2-{}.tgz
	 * 7.0.0, 6.3.1 (DEV)
	 */
	@ParameterizedTest
	@ValueSource(strings = {"7.0.0-rc8", "7.0.0-rc2", "7.0.0-rc1", "6.3.1 -> 6.3.2"})
	public void amazon2LinuxArmDev(String version) {
		assertThat(linuxWith(CommonArchitecture.ARM_64, AmazonVersion.AmazonLinux2), version)
			.resolveDevPackageTo("/linux/mongodb-linux-aarch64-amazon2-{}.tgz");
	}

	/*
	 * Amazon Linux 2 x64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon2-{}.tgz
   * 6.0.1 -> 6.0.5, 5.0.12 -> 5.0.15, 5.0.5 -> 5.0.6, 5.0.0 -> 5.0.2, 4.4.16 -> 4.4.19, 4.4.13, 4.4.11, 4.4.0 -> 4.4.9, 4.2.22 -> 4.2.24, 4.2.18 -> 4.2.19, 4.2.5 -> 4.2.16, 4.2.0 -> 4.2.3, 4.0.0 -> 4.0.28, 3.6.22 -> 3.6.23
	 */
	@ParameterizedTest
	@ValueSource(strings = {"6.0.8", "6.0.1 -> 6.0.6", "5.0.18 -> 5.0.19", "5.0.12 -> 5.0.15", "5.0.5 -> 5.0.6", "5.0.0 -> 5.0.2", "4.4.22", "4.4.16 -> 4.4.19", "4.4.13", "4.4.11", "4.4.0 -> 4.4.9", "4.2.22 -> 4.2.24", "4.2.18 -> 4.2.19", "4.2.5 -> 4.2.16", "4.2.0 -> 4.2.3", "4.0.0 -> 4.0.28", "3.6.22 -> 3.6.23"})
	public void amazon2Linux(String version) {
		assertThat(linuxWith(CommonArchitecture.X86_64, AmazonVersion.AmazonLinux2), version)
			.resolvesTo("/linux/mongodb-linux-x86_64-amazon2-{}.tgz");
	}

	/*
	 * Amazon Linux 2 x64 dev
	 * https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon2-{}.tgz
	 * 7.0.0, 6.3.1 (DEV)
	 */
	@ParameterizedTest
	@ValueSource(strings = {"7.0.0-rc8", "7.0.0-rc2", "7.0.0-rc1", "6.3.1 -> 6.3.1"})
	public void amazon2LinuxDev(String version) {
		assertThat(linuxWith(CommonArchitecture.X86_64, AmazonVersion.AmazonLinux2), version)
			.resolveDevPackageTo("/linux/mongodb-linux-x86_64-amazon2-{}.tgz");
	}

	/*
	 * Amazon Linux x64
	 * https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon-{}.tgz
	 * 5.0.18, 5.0.12 -> 5.0.15, 5.0.5 -> 5.0.6, 5.0.0 -> 5.0.2, 4.4.22, 4.4.16 -> 4.4.19, 4.4.13, 4.4.11, 4.4.0 -> 4.4.9, 4.2.22 -> 4.2.24, 4.2.18 -> 4.2.19, 4.2.5 -> 4.2.16, 4.2.0 -> 4.2.3, 4.0.0 -> 4.0.28, 3.6.0 -> 3.6.23, 3.4.9 -> 3.4.24, 3.4.0 -> 3.4.7, 3.2.0 -> 3.2.22, 3.0.0 -> 3.0.15
	 */
	@ParameterizedTest
	@ValueSource(strings = {"5.0.18 -> 5.0.19", "5.0.12 -> 5.0.15", "5.0.5 -> 5.0.6", "5.0.0 -> 5.0.2", "4.4.22 -> 4.4.23", "4.4.16 -> 4.4.19", "4.4.13", "4.4.11", "4.4.0 -> 4.4.9", "4.2.22 -> 4.2.24", "4.2.18 -> 4.2.19", "4.2.5 -> 4.2.16", "4.2.0 -> 4.2.3", "4.0.0 -> 4.0.28", "3.6.0 -> 3.6.23", "3.4.9 -> 3.4.24", "3.4.0 -> 3.4.7", "3.2.0 -> 3.2.22", "3.0.0 -> 3.0.15"})
	public void amazonLinux(String version) {
		assertThat(linuxWith(CommonArchitecture.X86_64, AmazonVersion.AmazonLinux), version)
			.resolvesTo("/linux/mongodb-linux-x86_64-amazon-{}.tgz");
	}

	private static Platform linuxWith(CommonArchitecture architecture, de.flapdoodle.os.Version version) {
		return ImmutablePlatform.builder()
			.operatingSystem(CommonOS.Linux)
			.architecture(architecture)
			.version(version)
			.build();
	}

	private static HtmlParserResultTester assertThat(Platform platform, String versionList) {
		return HtmlParserResultTester.with(
			new AmazonPackageFinder(Command.Mongo),
			version -> Distribution.of(Version.of(version), platform),
			versionList);
	}

}