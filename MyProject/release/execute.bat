@echo off

REM set classpath=C:\Git\MyProject\bin;C:\Git\MyProject\libs\*
set classpath=../../MyProject/bin;../../MyProject/libs/*

java org.testng.TestNG ../../MyProject/src/testng.xml
