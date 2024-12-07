@echo off

::taskkill -f -t -im javaw.exe
wmic process where (commandline LIKE "%%backend-1.0-SNAPSHOT.jar%%" and caption="javaw.exe") call terminate

set BIN_PATH=/d %~dp0
echo "BIN_PATH: %BIN_PATH%"

cd ../backend

if "%computername%"=="DESKTOP-19P4R6L" (
    echo "%computername% is my pc"
    set MAVEN_HOME=D:\software\Java\apache-maven-3.6.3\bin
    set JAVA_HOME2=D:\software\Java\jdk1.8.0_111\jre\bin
) else (
    echo "%computername% is not my pc"
    set MAVEN_HOME=D:\workspace\apache-maven-3.3.3\bin
    set JAVA_HOME2=D:\workspace\Java\jdk1.8.0_221\bin
)

call %MAVEN_HOME%\mvn clean package -Dmaven.test.skip=true

call START "backend" "%JAVA_HOME2%\javaw" -jar ../backend/target/backend-1.0-SNAPSHOT.jar

echo "start backend success!"

cd ../Vue-View
call npm install
call npm run dev

echo "start Vue-View success!"

pause