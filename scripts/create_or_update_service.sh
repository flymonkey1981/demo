#!/bin/bash

ln -s -f /var/app/demo-0.0.1-SNAPSHOT.jar /etc/init.d/shopping-app
update-rc.d shopping-app defaults

