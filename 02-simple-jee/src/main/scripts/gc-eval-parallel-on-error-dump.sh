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
-Xmx24m \
-XX:+UseParallelGC \
-XX:HeapDumpPath=$tpath \
-XX:+HeapDumpOnOutOfMemoryError \
houseware.learn.tunning.onerror.GCEval