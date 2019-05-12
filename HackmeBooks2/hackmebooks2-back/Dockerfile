FROM openjdk:11-jre-slim

RUN mkdir /hackmebooks2-back
COPY target/HacmeBooks2-0.0.1-SNAPSHOT.jar /hackmebooks2-back/back.jar

# Uncomment for more security
# cf.
#  - https://snyk.io/blog/10-docker-image-security-best-practices/
#  - https://docs.docker.com/develop/develop-images/dockerfile_best-practices/
# RUN groupadd -r back && useradd -r -s /bin/false -g back back
# RUN chown -R back:back /hackmebooks2-back
# USER back

WORKDIR /hackmebooks2-back
ENTRYPOINT java -jar back.jar
