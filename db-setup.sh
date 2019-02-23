# !bash

brew install mongodb

mongoimport --port 32768 -c ca_p3 --type csv --file GlobalTemperatures.csv --headerline

mongo --port 32768