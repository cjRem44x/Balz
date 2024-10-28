@echo off

set src=%cd%\src\java
set bin=%cd%\bin
cd %src%
javac -d %bin% *.java 
cd %bin%
jar cfve balz.jar Main *.class

pause
