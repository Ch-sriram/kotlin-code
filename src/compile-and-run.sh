#!/bin/bash

if [ $# -ne 1 ]; then
  echo "Usage: ./compile-and-run.sh <filename>"
  exit 1
fi

kotlinc "${1}.kt" -include-runtime -d "${1}.jar" && java -jar "${1}.jar"
