#!/usr/bin/env bash

brew install mongodb

mongoimport -c ca_p3 --type csv --file GlobalTemperatures.csv --headerline

mongo