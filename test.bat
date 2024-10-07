@echo off

set src=%cd%\src\java
set bin=%cd%\bin
cd %src%
javac -d %bin% *.java 
cd %bin%
java Main

pause
