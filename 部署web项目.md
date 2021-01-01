购买服务器，域名，将域名绑定到服务器。
在服务器上安装jdk，mysql，tomcat，然后将项目打包成war包放在tomcat目录下的webapps/Root的目录下面（先将root下面的文件清空，然后放入war包，最后解压）
#1.安装jdk1.8
	yum install java-1.8.0-openjdk* -y（会自动配置好环境，不需要自己手动配置）
#2.安装mysql
	百度上面方法很多
#3.安装tomcat
	1 wget +下载链接：就能实现下载，在tomcat官网找下载链接

	2 进入到目录 /usr/local/ 中：cd /usr/local/

	3 创建目录 /usr/local/tools，如果有则忽略：mkdir -p tools

	4 创建 /usr/local/tomcat 目录，如果已存在则忽略：mkdir -p tomcat

	5 进入到目录 /usr/local/tools 中：cd tools/

	6 下载 apache-tomcat-9.0.0.M4.tar.gz 文件：wget http://mirror.bit.edu.cn/apache/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.tar.gz

	7 解压缩 apache-tomcat-9.0.0.M4.tar.gz：tar -zxvf apache-tomcat-9.0.0.M4.tar.gz

	8 将通过解压得到的 apache-tomcat-9.0.0.M4 文件复制到 /usr/local/tomcat 目录中：mv apache-tomcat-9.0.0.M4 ../tomcat/

	9 打开文件 /etc 目录下的 profile 文件：vim /etc/profile

	将如下代码追加到 profile 文件末尾：

	# idea - tomcat9 config start - 2016-05-01

	CATALINA_HOME=/usr/local/tomcat/apache-tomcat-9.0.0.M4
	
	CATALINA_BASE=/usr/local/tomcat/apache-tomcat-9.0.0.M4

	PATH=$PATH:$CATALINA_BASE/bin

	export PATH CATALINA_BASE

	# idea - tomcat9 config end - 2016-05-01 保持并推出:wq!

	10 进入到 /usr/local/tomcat/apache-tomcat-9.0.0.M4/bin 目录中：cd ../bin/

	11 打开 vi catalina.sh 文件：

	在 # OS specific support. 前面加入如下代码：

	**JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5.x86_64（
	找到安装jdk的路径方法如下：
		[root@localhost apache-tomcat-7.0.78]# which java
		/usr/bin/java
		[root@localhost apache-tomcat-7.0.78]# ls -lrt /usr/bin/java
		lrwxrwxrwx. 1 root root 22 7月  23 14:43 /usr/bin/java -> /etc/alternatives/java
		[root@localhost apache-tomcat-7.0.78]# ls -lrt /etc/alternatives/java
	l	rwxrwxrwx. 1 root root 73 7月  23 14:43 /etc/alternatives/java -> /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5.x86_64/jre/bin/java
	）

	**JRE_HOME=$JAVA_HOME/jre

	键入 Esc 并输入“:wq!”保持并退出;

	12 启动 tomcat 服务：./startup.sh
	
	打开浏览器输入 IP 地址看看吧!如果出现了我们的可爱的“小黄猫”则表明我们的 Tomcat 已提供服务啦!

	13 关闭 tomcat 服务：./shutdown.sh

#4.将应用部署到tomcat根目录的三种方法：<br/>
**方法一**：
	（最简单直接的方法，很好用）    删除原 webapps/ROOT 目录下的所有文件，将应用下的所有文件和文件夹复制到ROOT文件夹下。<br/>
**方法二：**   删除原 webapps/ROOT 目录下的所有文件，修改文件“conf/server.xml”，在Host节点下增加如下Context的内容配置:Context path="" docBase="C:/apache-tomcat-6.0.32/myapps/bc.war"></Context>
	
	注意：    
		1）path 的值设置为空；    
		2）应用不要放到tomcat的webapps目录下(如上述配置是放到自定义的文件夹myapps内的)，否则访问时路径很有问题；   
		3）docBase指定到绝对路径。    如此设置后重启tomcat，如果docBase指向的是war文件，会自动将war解压到 webapps/ROOT 目录；
		如果docBase指向的是应用已解压好的目录，如 docBase="C:/apache-tomcat-6.0.32/myapps/bc"，tomcat不会生成webapps/ROOT目录
		（这种情况下之前可以不用删除webapps/ROOT目录，但webapps/ROOT目录内的内容是无法访问的），访问时将直接使用docBase指定的目录。<br/>


**方法三：**    与方法二类似，但不是修改全局配置文件“conf/server.xml”，而是在“conf/Catalina/localhost”目录下增加新的文件"ROOT.xml"（注意大小写哦），文件内容如下：<?xml version="1.0" encoding="UTF-8"?>Context path="" docBase="C:/apache-tomcat-6.0.32/myapps/bc.war"></Context>