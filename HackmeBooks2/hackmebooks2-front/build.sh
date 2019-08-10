#!/bin/sh

DIRNAME=$(dirname $0)
cd $DIRNAME

ng build --configuration=production
