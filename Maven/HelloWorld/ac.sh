export GRAALVM_HOME=/home/johan/graal/github/fork/graal/sdk/mxbuild/linux-amd64/GRAALVM_UNKNOWN_JAVA11/graalvm-unknown-java11-20.0.0-dev
$GRAALVM_HOME/bin/native-image \
-Djdk.internal.lambda.eagerlyInitialize=false \
-H:+ExitAfterRelocatableImageWrite \
-H:CompilerBackend=llvm \
-H:-SpawnIsolates \
-H:TempDirectory=/tmp/ll \
-Dsvm.platform=org.graalvm.nativeimage.Platform\$LINUX_AARCH64 \
-Dsvm.targetArch=arm64 \
-H:CustomLLC=/home/johan/graal/github/llvm/llvm-project/build/bin/llc \
-H:CustomLD=/opt/android-ndk-r19c/toolchains/llvm/prebuilt/linux-x86_64/bin/ld.lld \
-cp target/classes \
hello.HelloWorld
