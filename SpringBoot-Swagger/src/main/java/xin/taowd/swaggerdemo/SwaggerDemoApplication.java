package xin.taowd.swaggerdemo;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }


    @ApiOperation(value = "根目录", notes = "第一个测试访问接口，HelloWorld")
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
}
