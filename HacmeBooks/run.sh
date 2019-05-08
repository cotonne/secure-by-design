#!/bin/sh

BASE=$(dirname "$0")
cd $BASE

java -cp ./hsqldb-2.4.1.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb &

sleep 10

mvn -DskipTests -Dmaven.test.skip -Djetty.http.port=8989 clean jetty:run
