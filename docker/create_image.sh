#!/bin/bash
pushd ../
export SOFTWARE_VERSION=$(grep -oPm1 "(?<=<version>)[^<]+" "pom.xml")

docker build -f docker/Dockerfile -t openvidu/openvidu-smmc .
docker tag openvidu/openvidu-smmc:latest openvidu/openvidu-smmc:$SOFTWARE_VERSION