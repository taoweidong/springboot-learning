# SpringBoot学习笔记-整合SpringDataJPA

## JdbcTemplate

为了使 JDBC 更加易于使用,Spring 在 JDBCAPI 上定义了一个抽象层, 以此建立一个JDBC存取框架.作为 SpringJDBC 框架的核心, JDBC 模板的设计目的是为不同类型的JDBC操作提供模板方法. 每个模板方法都能控制整个过程,并允许覆盖过程中的特定任务.通过这种方式,可以在尽可能保留灵活性的情况下,将数据库存取的工作量降到最低.

## JdbcTemplate主要方法：

- execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
- update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
- query方法及queryForXXX方法：用于执行查询相关语句；
- call方法：用于执行存储过程、函数相关语句。

## 案例实现

### 创建案例工程：SpringBoot-jdbctemplate

![](https://i.imgur.com/v0WJxpG.png)

### 添加依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

如果在JPA已经加入的话，则可以不用引入以上的配置。
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```

### 创建实体

```
@Setter
@Getter
@ToString
@Entity
public class User {

    /**
     * ID 唯一标识
     */
    @Id
    //指定主键的生成策略，MySql默认是自增长
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}

```

### 创建Dao层，供service层调用

```
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据Id查询用户数据
     *
     * @param id
     * @return
     */
    public User getUserById(long id) {
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    /**
     * 获取单个列的值或做统计查询
     * 使用 queryForObject(String sql, Class<Long> requiredType)
     */
    public long testQueryForObject2() {
        String sql = "SELECT count(id) FROM user ";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}

```

### 创建Services层

```
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 根据Id查询单个用户
     *
     * @param id
     * @return
     */
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    /**
     * 查询用户总数
     *
     * @return
     */
    public long getCount() {
        return userDao.testQueryForObject2();
    }
}
```

### 创建Controller

```
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/findById")
    public User findById(long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/getCount")
    public String getCount() {
        return "User表的总数为：" + userService.getCount();
    }

}
```

### 启动类处理

```
@SpringBootApplication
@Controller
public class App {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```

### 启动测试

![](https://i.imgur.com/Hij0OoF.png)

个人博客：[http://taoweidong.com/](http://taoweidong.com/)

GitHub源码地址：[https://github.com/TaciturnK/springboot-learning](https://github.com/TaciturnK/springboot-learning)