# SpringBoot学习笔记-整合Thymeleaf

# Thymeleaf简介

> Thymeleaf是一个Java模板引擎开发库，可以处理和生成HTML、XML、JavaScript、CSS和文本，在Web和非Web环境下都可以正常工作。它更适合处理Web应用程序中的视图层（View Layer），但是也支持在离线环境处理各种格式的文件。Thymeleaf遵循Apache 2.0许可发布。

![](http://jbcdn1.b0.upaiyun.com/2016/01/27d577c88485fbbfbfea95bfbf70e81c.png)

> 此外，Thymeleaf还提供了一个可选模块Spring MVC集成，可以用来替换应用中的JSP甚至是HTML5。

> Thymeleaf的首要目标是提供一个优雅、结构良好的方式创建模板。Thymeleaf的Standard 和SpringStandard 方言可以用来创建功能强大的natural template，该模板可在浏览器中正确显示，还可以作为静态模板使用。你还可以扩展Thymeleaf开发自己的方言。

# 了解Thymeleaf

Thymeleaf看起来像下面这样：

	<table>
	  <thead>
	    <tr>
	      <th th:text="#{msgs.headers.name}">Name</th>
	      <th th:text="#{msgs.headers.price}">Price</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr th:each="prod : ${allProducts}">
	      <td th:text="${prod.name}">Oranges</td>
	      <td th:text="${#numbers.formatDecimal(prod.price,1,2)}">0.99</td>
	    </tr>
	  </tbody>
	</table>

快速浏览代码可以发现其中包含了国际化表达式 (#{...})、变量/模型属性计算表达式 (${...}) 和工具函数 (#numbers.formatDecimal(...))。上面的(X)HTML代码可以作为 prototype 在浏览器直接显示，无需执行——这就是所谓的natural template。

除此以外还有：完整的Spring MVC集成（可选）——包括form绑定、属性编辑器和验证消息、文本/javascript内联和智能模板缓存系统。

# 核心功能

- 针对XML、XHTML和HTML5的Java模板引擎。可扩展支持其他模板格式。
- 在Web和非Web环境（离线）下都可以正常工作。不依赖Servlet API。
- 基于模块化功能集合，即所谓的方言。
   - 将方言特性（比如求值、迭代等）与模板标记或属性关联。
   - 自带两种方言：Standard 和SpringStandard （针对Spring MVC应用，语法与Standard相同）。
   - 开发者可扩展自己的方言。
- 自带多种模板模式（template mode）可扩展：
   - XML：验证是否符合DTD标准
   - XHTML 1.0和1.1：验证是否标准DTD
   - HTML5：支持XML形式代码和基于遗留代码的HTML5。自动清理费XML遗留代码并转换为XML格式。
- 完整的国际化支持（可扩展）
- 可配置、高性能解析模板缓存，将输入/输出开销减到最小。
- 自动DOCTYPE翻译：从DTD模板转换成DTD结果，对模板和结果代码进行验证（可选）。
- 高度可扩展：可根据需要作为模板引擎使用
- 提供了完整的文档，附带若干应用程序示例。


# SpringBoot整合Thymeleaf步骤

- 创建SpringBoot工程
- 在Pom.xml文件中添加依赖

----------

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

- application.properties文件中进行配置(关闭thymeleaf缓存)

----------

	############################################################
	#
	# thymeleaf 静态资源配置
	#
	############################################################
	spring.thymeleaf.prefix=classpath:/templates/
	spring.thymeleaf.suffix=.html
	spring.thymeleaf.mode=HTML5
	spring.thymeleaf.encoding=UTF-8
	spring.thymeleaf.content-type=text/html
	# 开发过程中关闭缓存, 即时刷新, 上线生产环境需要改为true
	spring.thymeleaf.cache=false

- 编写模板文件.html

----------

	<!DOCTYPE html>
	<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
	<head>
	    <meta charset="UTF-8"/>
	    <title>Thymeleaf 学习</title>
	</head>
	<body>
	
	<h1>hello thymeleaf</h1>
	<br/>
	Welcome <span th:text="${name}"></span>
	
	<h1 th:inline="text">Hello.v.2</h1>
	<p th:text="${hello}"></p>
	
	</body>
	</html>

说明：

1. th:text  用来将内容输出到所在标签的body中。
2. #{home.welcome} 用来引入数据home对象中的 welcome属性。
3. 可以用th:utext 用来显示“unescaped ” 的html内容。


----------

- 编写访问模板文件controller

----------

	@Controller
	@RequestMapping("/hello")
	public class TemplatesController {
	
	    @RequestMapping("/index")
	    public String hello(Map<String, Object> map) {
	
		//ModelAndView modelAndView = new ModelAndView("hello");
	        // modelAndView.add
	        map.put("name", "Andy");
	        map.put("hello", "测试一下喽！！！！");
	        //return modelAndView;
	        return "index";
	    }
	}
	
	
