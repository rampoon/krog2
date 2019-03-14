cd $KROG_HOME/outfiles
#CLASSPATH=$KROG_HOME/lib/krog2.jar:$KROG_HOME/lib/mysql-connector-java-5.1.28-bin.jar
#CLASSPATH=$HOME/lib/krog2.jar:$HOME/lib/mysql-connector-java-5.1.28-bin.jar
CLASSPATH=$KROG_HOME/lib/krog2.jar
export CLASSPATH
echo CLASSPATH=$CLASSPATH
"$JAVA_HOME/bin/java" se.krogrannet.ExportForMeos
