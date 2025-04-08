PROJECT_NAME="loginTest"
# suppresion de build
rm -r build

# creation de build
mkdir build

#creation de classes dans build
mkdir -p build/WEB-INF/classes

#compilation de tout les .java -> classes avec le .jar
javac -cp .:lib/* -d build/WEB-INF/classes $(find src/main/java -name "*.java")

#copi du webbapp/* vers /build
cp -r src/main/webbapp/* build/

#creation du .war 
rm $PROJECT_NAME.war
jar -cvf $PROJECT_NAME.war -C build .

#copi du .war vers tomcate/webapps
cp -rf $PROJECT_NAME.war /opt/tomcat/webapps/