# twitter4j-spring-mvc (2014)

Geolocate live user tweets worldwide

http://www.eirwig.com/

Java + Spring MVC + Twitter Streaming API + Google Maps API

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