#!/bin/bash
rm -rf target
#mvn clean install package -DskipTests -e -X
#mvn clean install package -e -X
mvn clean install package
exit 0;
