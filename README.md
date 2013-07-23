jAngo (Ango, for Java)
=========

I love Django. It has become my go to web framework of choice when I want to quickly do something. 

One day I decided (try) to replicate the Django Framework but in Java. Why? Various reasons but mainly because of what I said above.

What is in this repository (at the time of this writing) is about a few hours of prototyping the prototype. I wanted to test out a few things to see if it were possible. 

The repository contains:
jango - The Framework itself - The core and ext modules. 
core - The idea here is that a Jango Project can be started up independent of a web server.
ext - Extensions that connect it to Undertow and other extensions that make it slightly more web-framework-y.

a test project - A project with two apps, one using the other. Used to test things out.

A test suite - Some things are tested, probably poorly


I apologize for this code. Not much thought was put into it. If the proper way would take longer than the crappy way, I went the crappy way. It will all be rewritten.

Django people - please don't sue me into hell. I've no problem changing the name of this framework. Please let me know


What is working (mainly for the Undertow Implementation)
---------------------
* Routing
* Cookies
    * Reading cookies and setting cookies both work.
* Headers
    * Request
        * Works
    * Response
        * Works
* Distributable/installable apps
    * Works
* Templating
    * Done (Thanks to Mustache!)

Please note that I never promised any of these were working well. Just well enough under Undertow to play around with the ideas

What is missing for this to be functional
---------------------
* Sessions
* Need to parse out positional/named args in path.
* Need to reverse name lookup
* An ORM
* Caching
* Proper headers, probably
* A rewrite
* And a lot of other stuff.


What I would love to release as "apps"
---------------------
* Static Asset Management
* Forms
* Authentication (modeled on Django's)



Should this be used for production?
-------------------
I cannot stress NO enough.


