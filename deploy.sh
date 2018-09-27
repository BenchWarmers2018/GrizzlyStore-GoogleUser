#!/usr/bin/env bash
echo 'Deployment in progress'
pwd && cd target

if (( $(ps -ef | grep -v grep | grep grizzlystore-googleuser | wc -l) > 0)) 
	then
		echo "Google User service is running...attempting to stop service!"
		sudo systemctl stop grizzlystore-googleuser.service || true
fi

if [ -f grizzlystore-googleuser ] ; then
    sudo rm /etc/init.d/grizzlystore-googleuser || true
fi

cp *.jar /opt/GrizzlyStoreMicroServices/GrizzlyStore-GoogleUser.jar
sudo systemctl start grizzlystore-googleuser.service