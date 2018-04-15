#!/usr/bin/env bash

apath="`dirname \"$0\"`"
tpath="`( cd \"$apath/../../../target\" && pwd )`"
if [ -z "$tpath" ] ; then
  exit 1  # fail
fi
echo "path: $apath"
echo "target: $tpath"

echo "+UseParallelGC "

java \
-classpath $tpath/classes \
-Xmx40m \
-XX:+UseParallelGC \
-XX:+UnlockCommercialFeatures -XX:+FlightRecorder \
-XX:HeapDumpPath=$tpath \
-XX:+HeapDumpOnOutOfMemoryError \
-verbose:gc \
-XX:+PrintGCTimeStamps -Xloggc:$tpath/parallel.log  -XX:+PrintGCDetails \
houseware.learn.tunning.onerror.GCEval