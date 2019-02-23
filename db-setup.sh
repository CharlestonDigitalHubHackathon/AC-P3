#!/usr/bin/env bash

brew install mongodb

mongoimport -c global_temp --type csv --file GlobalTemperatures.csv --headerline
mongoimport -c city_temp --type csv --file GlobalLandTemperaturesByMajorCity.csv --headerline
