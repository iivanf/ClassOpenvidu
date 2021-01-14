#!/bin/bash
pushd ../
export SOFTWARE_VERSION=$(grep -oPm1 "(?<=<version>)[^<]+" "pom.xml")

docker build -f docker/Dockerfile -t iivanf/openvidu-smmc .
docker tag iivanf/openvidu-smmc:latest iivanf/openvidu-smmc:$SOFTWARE_VERSION