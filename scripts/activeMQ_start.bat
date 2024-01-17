@echo off
title Script to start ActiveMQ
echo ActiveMq starting...
cd "your-path\apache-activemq-6.0.0\bin"
start "" http://127.0.0.1:8161/admin/
activemq start
pause