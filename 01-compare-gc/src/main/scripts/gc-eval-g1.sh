#!/usr/bin/env bash

apath="`dirname \"$0\"`"
tpath="`( cd \"$apath/../../../target\" && pwd )`"
if [ -z "$tpath" ] ; then
  exit 1  # fail
fi
echo "path: $apath"
echo "target: $tpath"

echo "+UseG1GC "

java \
-classpath $tpath/classes \
-Xmx40m \
-XX:+UseG1GC \
-XX:+UnlockCommercialFeatures -XX:+FlightRecorder \
-XX:HeapDumpPath=$tpath \
-XX:+HeapDumpOnOutOfMemoryError \
-verbose:gc \
-XX:+PrintGCTimeStamps -Xloggc:$tpath/g1.log  -XX:+PrintGCDetails \
houseware.learn.tunning.onerror.GCEval