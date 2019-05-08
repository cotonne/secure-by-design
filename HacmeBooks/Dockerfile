FROM maven:3-jdk-8-alpine

RUN apk update && \
  apk add git && \
  rm -rf /var/cache/apk/*

COPY hsqldb-2.4.1.jar hsqldb-2.4.1.jar

RUN git clone https://github.com/cotonne/secure-by-design.git && \
  cd secure-by-design/HacmeBooks/ && \ 
  cp /hsqldb-2.4.1.jar hsqldb.jar && \
  run.sh

