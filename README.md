# twitter4j-spring-mvc (2014)

Geolocate live user tweets worldwide

http://www.eirwig.com/

or

http://ec2-54-194-27-150.eu-west-1.compute.amazonaws.com:8080/eirwig-spring-mvc/

Java + Spring MVC + Twitter Streaming API + Google Maps API + HTML5 Server Sent Events

Packaged as eirwig-spring-mvc.war via maven 

Deployable via any Java Servlet implementation (maven tomcat plugin) / any JEE webserver.

-----------------------
Setup dev account on https://dev.twitter.com.

Setup a new app and get yourself your oath details for xxxxx_SET_ME_UP_xxxxxxxx

create an etc/config/eirwig_ie.properties file as shown

oauth.consumerKey=xxxxx_SET_ME_UP_xxxxxxxx

oauth.consumerSecret=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessToken=xxxxx_SET_ME_UP_xxxxxxxx

oauth.accessTokenSecret=xxxxx_SET_ME_UP_xxxxxxxx

logdir=

---------------------------------------

To build & deploy:

$ clean install tomcat7::run

..

Running war on http://localhost:8080/eirwig-spring-mvc

-----------------------
