#!/usr/bin/env bash

echo 'Deployment in process'
pwd && cd target
sudo systemctl stop grizzly-google.service || true
sudo rm /etc/init.d/grizzly-google || true
sudo ln -s grizzlystoregoogleuser-0.0.1-SNAPSHOT.jar /etc/init.d/grizzly-google
sudo systemctl start grizzly-google.service
