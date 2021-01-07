# Classroom on OPENVIDU

Para compilar:

> docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.16.0

> cd src/angular/frontend/

> ng build --output-path ../../main/resources/static

> cd ../../../

> mvn clean package exec:java

Unha vez feito esta no [localhost:5000](https://localhost:5000/)