FROM python:3-alpine 

RUN mkdir /hackmebooks2-front
COPY dist/HacmeBooks2/** /hackmebooks2-front/

# Uncomment for more security
# cf.
#  - https://snyk.io/blog/10-docker-image-security-best-practices/
#  - https://docs.docker.com/develop/develop-images/dockerfile_best-practices/
# RUN groupadd -r front && useradd -r -s /bin/false -g front front
# RUN chown -R front:front /hackmebooks2-front
# USER front

WORKDIR /hackmebooks2-front
ENTRYPOINT python -m http.server 4200

