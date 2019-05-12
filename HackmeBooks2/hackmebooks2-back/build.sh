#!/bin/sh

DIRNAME=$(dirname $0)
cd $DIRNAME

mvn clean package
