FROM maven:3-jdk-8-alpine

RUN apk update && \
  apk add git && \
  rm -rf /var/cache/apk/* && \
  git clone https://github.com/cotonne/secure-by-design.git && \
  cd secure-by-design/HacmeBooks/ && \
  run.sh

