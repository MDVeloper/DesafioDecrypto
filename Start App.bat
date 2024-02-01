@echo off
title Mdveloper App
color 00
:start

PATH = "C:\Program Files\Java\jdk-19\bin"

java -jar C:\Users\zk-\Desktop\DesafioDecrypto\docker\snapshot\ms-db-1.0.0-SNAPSHOT.jar --spring.profiles.active=test

if ERRORLEVEL 2 goto restart
if ERRORLEVEL 1 goto error
goto end

:restart
echo.
echo Admin Restarted Game Server.
echo.
goto start

:error
echo.
echo Game Server terminated abnormally!
echo.

:end
echo.
echo Game Server Terminated.
echo.
pause