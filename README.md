# twitter4j-spring-mvc [![Build Status](https://travis-ci.org/sligokid/twitter4j-spring-mvc.svg?branch=master)](https://travis-ci.org/sligokid/twitter4j-spring-mvc)

Geolocate live user tweets worldwide

## Table of Contents
  - [Introduction](#introduction)
  - [Overview](#overview)
  - [Demo](#demo)
  - [Install](#install)
  - [Limitations](#limitations)

## Introduction

This Live streaming demonstration was created as part of an entry into the Apps 4 Gaps competiition http://apps4gaps.ie/.
Apps4Gaps is an international competition aimed at encouraging young people to provide concepts and create applications utilising Open Data freely available.

A live subscription is made to Twitters streaming API, each tweet is processed, its geolocation parsed, plotted on Google maps via the heat map. The open data used in this app are the CSO user population density figures for Ireland.

## Overview

This Webapp is a personal project developed to demonstrate the integration of: 
- Spring MVC
- REST
- Twitter Streaming API
- Google Maps API
- Heatmap.js 
- HTML5 Server Sent Events

The goal of this project is to showcase a live streaming twitter sourced headmap.


## Demo

![docs-diagram](https://user-images.githubusercontent.com/6519496/28295550-367e6c04-6b59-11e7-9981-afdb519c1898.png)


![docs-diagram](https://user-images.githubusercontent.com/6519496/28296041-75db6614-6b5d-11e7-86ae-ee15cceb8b82.png)

http://www.eirwig.com/

or

http://ec2-54-194-27-150.eu-west-1.compute.amazonaws.com:8080/eirwig-spring-mvc/

## Install

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

$ mvn clean install tomcat7::run

..

Running war on http://localhost:8080/eirwig-spring-mvc

-----------------------

## Limitations
Only 1% of the streaming API is made available to developers
