
## Java <version> Setup for macOS

This guide provides step-by-step instructions for installing and configuring Java <version> on your Mac using Homebrew.

## Installation

1. Install OpenJDK <version>: `brew install openjdk@<version>`

2. Verify available Java versions: `/usr/libexec/java_home -V`

3. Set Java <version> as default:
	 ```bash
	 export JAVA_HOME=$(/usr/libexec/java_home -v <version>)
	 export PATH=$JAVA_HOME/bin:$PATH
	 ```

4. Verify the installation:: `java -version`


Example output:
```
java -version
openjdk version "22.0.2" 2024-07-16
OpenJDK Runtime Environment Homebrew (build 22.0.2)
OpenJDK 64-Bit Server VM Homebrew (build 22.0.2, mixed mode, sharing)
```


## Uninstallation

To remove OpenJDK <version>: `brew uninstall openjdk@<version>

## Running Java <version> Examples

To run Java <version> example files with preview features:
`java --enable-preview --source <version> <SampleFileName.java>`


## New Features in Java <version>

For a comprehensive list of new features and improvements in Java <version>, please refer to the [official Oracle announcement](https://www.oracle.com/ca-en/news/announcement/oracle-releases-java-22-2024-03-19/).

## Troubleshooting

If you encounter any issues during installation or usage, please check the following:

1. Ensure Homebrew is up to date: `brew update`
2. Verify your system's PATH includes the Homebrew installation directory
3. Check for any conflicting Java installations

For further assistance, consult the [OpenJDK documentation](https://openjdk.java.net/install/) or the [Homebrew documentation](https://docs.brew.sh/).

**Note : You can work directly in `IntelliJ IDEA 2024.x.x` Screenshot attached.

### To be continued ...