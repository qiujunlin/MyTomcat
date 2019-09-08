## 手写一个简易Tomcat
### Http协议
  HTTP（Hypertext Transfer Protocol）：超文本传输协议。是一个应用层协议
  一个HTTP的请求包括：请求行(request line)、请求头部(header)、空行 和 请求数据 四个部分组成。
 一个http协议的结构如图：
 ![](https://github.com/qiujunlin/MyTomcat/blob/master/src/main/resources/http%E8%AF%B7%E6%B1%82%E5%A4%B4.webp)
 请求格式：
  
  ```html
GET /Servlet2 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
```

### 我的思路：
1. 首先要对http的请求进行封装，新建一个MyRequest，并写一个请求流对象取出请求信息，相当于Tomcat中的HttpServletRequest对象
2. 有请求对象，就需要一个相应对象，新建一个响应对象，封装响应信息，其实就是一个html页面，并把返回的数据写入到html中。
3. 有了请求对象和相应对象，Tomcat中还需要Servlet，tomcat会每一个请求分配一个Servlet，在servlet里面进行业务的处理，简单定一个抽象类MyServlet
4. 有了servelt，那么就需要对servlet进行配置，Tomcat是通过xml的方式对servlet进行配置，想到一个简易的方法，定义一个ServletMapping类，对配置信息进行封装，那么要配置多个servlet，定一个List集合来封装多个Servlet。
5. 最重要的一步就是定义Server， 创建一个Server类，把它当做服务器端，编写start（）方法，启动服务，接收客户端的访问。启动服务的同时，要读取配置文件，这里就是去读取ServeletMappingConfig类，把请求地址和Servlet类名封装到一个Map对象中。收到请求后，取出里面的请求路径，匹配对应的servlet，通过反射去执行我们自定义的servlet，执行完成之后，向浏览器发送响应，一个简单的手写tomcat就完成了。


#### 结果





