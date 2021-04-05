#!/usr/bin/env bash

set -e # stop script at any error

mvn clean install

# Windows 10, username hardcoded
mv "target\desktop-time-widget-1.0-SNAPSHOT-jar-with-dependencies.jar" "C:\Users\Jarcionek\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\Desktop-Time-Widget.jar"

# TODO cannot replace the file if it is currently running...
