#!/usr/bin/env bash

apath="`dirname \"$0\"`"
tpath="`( cd \"$apath/../../../target\" && pwd )`"
if [ -z "$tpath" ] ; then
  exit 1  # fail
fi
echo "path: $apath"
echo "target: $tpath"



java \
  -classpath $tpath/classes \
  -Xmx30m \
  -XX:OnOutOfMemoryError="echo $(date)>>oome.txt" \
  -XX:HeapDumpPath=$tpath \
  -XX:+HeapDumpOnOutOfMemoryError \
  houseware.learn.tunning.onerror.OnError