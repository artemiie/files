/**
 * Apache Tomcat - web server, джава приложение, которое умеет обрабатывать HTTP запросы от других польхователей и генерировать HTTP ответы.
 *                 Альтернативы GlassFish, JBoss. Но Tomcat самый распространенный и используется в Спринг.
 *                 
 * Томкат разбит на 3 модуля:
 *
 *      Catalina (servlet container)
 *
 *      Coyote (HTTP connector) - отвечает за принятие и отправку запросов.
 *
 *      Jasper (JSP engine) - Java Server Pages
 *
 *   Web Server (Tomcat)
 *          - /bin
 *          - /conf
 *          - /lib
 *          - /logs
 *          - /webapps <——— Web Archive (WAR) - все приложения которые пишем, все что нужно сделать, это собрать архив
 *                                   - /WEB-INF/classes
 *                                   - /WEB-INF/lib
 *                                   - /WEB-INF/web.xml
 *                                   - /css
 *                                   - /js
 *                                   - /images
 *                                   - /jsp
 *                                   ...
 *
 *
 *  /bin/startup.bat to start Tomcat (port by default 8080)
 *  /conf/server.xml to change Listener port (by default  8005)
 *  /conf/server.xml to change Connector port (by default  8080)
 *  /conf/tomcat-users.xml to add/change users
 *  http://localhost:8080/manager/html to open Tomcat Web Application Management
 *
 *
 *
 *
 *
 */