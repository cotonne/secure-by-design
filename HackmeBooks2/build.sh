#!/bin/sh

set -x

MODULES="hackmebooks2-back hackmebooks2-front hackmebooks2-reverse"

for module in $MODULES
do
  $module/build.sh
done

docker-compose build
