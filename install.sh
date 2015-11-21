DATE=`date +%F`
sudo service tomcat7 stop
echo "Backing up.."
#cp -v /var/lib/tomcat7/webapps/eirwig-spring-mvc.war /var/tmp/eirwig-backup/eirwig-spring-mvc.war.${DATE}
echo "Removing var/lib/tomcat7/webapps/eirwig-spring-mvc.war"
sudo rm /var/lib/tomcat7/webapps/eirwig-spring-mvc.war
echo "Removing var/lib/tomcat7/webapps/eirwig-spring-mvc/"
sudo rm -rf /var/lib/tomcat7/webapps/eirwig-spring-mvc
echo "Installing..."
sudo cp -v target/eirwig-spring-mvc.war /var/lib/tomcat7/webapps/
sudo service tomcat7 start
ls -tlr /var/lib/tomcat7/webapps/
