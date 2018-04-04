# SpringBoot学习笔记-整合SpringDataJPA

##　JPA简介

- JPA全称是Java Persistence API。JPA通过JDK5.0注解或者XML描述对象-关系表的映射关系，并将运行期的实体对象持久化到数据库中。
- JPA是SUN公司提出的Java持久化规范。他为Java开发人员提供了一种对象/关系映射工具来管理Java应用中的关系数据。
- 持久化，即把数据（如内存中的对象）保存到可永久保存的存储设备中(如磁盘)。持久化的主要应用是将内存中的对象存储在数据库中，或者存储在磁盘文件中、XML数据文件中等等。
- 持久化是将程序数据在持久状态和瞬时状态间转换的机制
- JDBC就是一种持久化机制。文件IO也是一种持久化机制。

##　Hibernate简介

Hiberntae是一个开放源代码的对象关系映射框架，它对JDBC进行了非常轻量级的对象封装，它将POJO与数据库表建立映射关系，是一个全自动的ORM框架，Hibernate可以自动生成SQL语句，自动执行，使得Java程序员可以随心所欲的使用对象编程思维来操作数据库。

Hibernate可以应用在任何使用JDBC的场合，既可以在Java的客户端程序使用，也可以在Servlet/JSP的Web应用中使用，最具革命意义的是，Hibernate可以在EJB的J2EE架构中取代CMP,完成数据持久化的重任。

## ORM简介

ORM是对象关系映射的意思，英语：Object Relational Mapping简称ORM，是一种程序技术，用于实现面向对象编程语言中不同系统类型的系统之间的数据转换。

## Spring Data简介

Spring Data是一个用于**简化数据库访问，并支持云服务的开源框架**。其主要目标是使得数据库的访问变得方便快捷，并支持Map-Reduce框架和云计算数据服务。此外，它还支持基于关系型数据库的数据服务，如Oracle RAC等。对于拥有海量数据的项目，可以用SpringData来简化项目的开发，就如Spring Framework对于JDBC，ORM的支持一样，Spring Data会让数据的访问变得更加方便。

## Spring Data JPA简介

可以极大的简化JPA的写法，可以在几乎不用写实现的情况下，实现对数据的访问和操作。除了CRUD外，还包括分页、排序等一些常用的功能。

Spring Data是一个开源框架，在这个框架中Spring Data JPA只是这个框架中的一个模块，所以才叫SpringDataJPA。如果单独使用JPA，你会发现和使用JDBC开发一样有点繁琐，**所有Spring Data JPA的出现就是为了简化JPA的写法，让你只需要编写一个接口继承一个类就能实现CRUD操作了。**

比如：当有一个 UserDao.findUserById() 这样一个方法声明，大致应该能判断出这是根据给定条件的ID查询出满足条件的User 对象。SpringData JPA 做的便是规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。

## JPA/Hibernate关系

JPA是一种规范，而Hibernate是它的一种实现。除了Hibernate，还有EclipseLink(曾经的topLink),OpenJPA等可供选择，所以使用JPA的一个好处就是：**可以更换实现而不必改动太多代码**。

## 案例实现

### 创建SpringBoot工程：SpringBoot-SpringDataJPA

![](https://i.imgur.com/jQZPrBa.png)

### Pom文件中添加：mysql,spring-data-jpa依赖

```xml

	<!--Thyneleaf依赖-->
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<!--MySql数据库依赖-->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>5.1.8</version>
	</dependency>
	<!--jdbc数据库连接-->
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-jdbc</artifactId>
	</dependency>
	<!--JPA依赖-->
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>

```

### application.properties文件中配置Mysql连接信息

```

	############################################################
	#
	# 数据源相关配置
	#
	############################################################
	spring.datasource.url=jdbc:mysql://localhost:3306/test
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.druid.initial-size=1
	spring.datasource.druid.min-idle=1
	spring.datasource.druid.max-active=20
	spring.datasource.druid.test-on-borrow=true
	spring.datasource.druid.stat-view-servlet.allow=true

```

### application.properties文件中配置JPA配置信息

```
########################################################
#
# SpringDataJPA配置
#
########################################################
# Specify the DBMS
spring.jpa.database = MYSQL
# 是否显示Sql语句
spring.jpa.show-sql = true
# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update
# Naming strategy
#[org.hibernate.cfg.ImprovedNamingStrategy  #org.hibernate.cfg.DefaultNamingStrategy]
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

### 测试

#### 创建实体类

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

> 使用@Entity进行实体类的持久化操作，当JPA检测到我们的实体类中有@Entity注解时，会在数据库中生成对应的表结构信息。
>
> 使用@Id指定主键
>
> 使用@GeneratedValue(strategy=GenerationType.AUTO)指定主键生成策略

#### 创建JPA Repository类操作持久化(CrudRepository)

```
public interface UserRepository extends CrudRepository<User, Integer> {
}
```

> **注意**：CrudRepository第一个参数是持久化的类，第二个参数是持久化类的Id类型

#### 创建service类

```java
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    /**
     * 保存数据或者更新数据
     * 如果Id已存在就是更新操作，如果Id不存在就是新增操作
     * @param user
     */
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    /**
     * 更新数据
     *
     * @param user
     */
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Transactional //添加事务绑定
    public void delete(int id) {
        userRepository.delete(id);
    }
    /**
     * 查询所有数据
     *
     * @return
     */
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
```

#### 创建Restful请求测试类

```
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("李测试");
        user.setAge(25);
        userService.save(user);
        return "Save OK";
    }
    @RequestMapping("/delete")
    public String delete() {
        userService.delete(1);
        return "Delete OK";
    }
    @RequestMapping("/getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }
}
```

#### 使用RestClient工具测试Restful接口

![](https://i.imgur.com/HyzY045.png)

![](https://i.imgur.com/Iahtv1o.png)

![](https://i.imgur.com/fIH6MzG.png)

## Spring Data常用接口

### Repository接口

Repository接口是Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法：如下所示

```
public interface User2Repository extends Repository<User, Integer> {
    /**
     * 根据name查询
     * @param name
     * @return
     */
    public User findByName(String name);
}
```

**Repository接口注意事项：**

- Repository是一个空接口，即是一个标记接口；
- 若我们定义的接口继承了Repository，则该接口会被IOC容器识别为一个Repository Bean纳入到IOC容器中，进而可以在该接口中定义满足一定规范的方法。
- 实际上也可以通过@RepositoryDefinition,注解来替代继承Repository接口。
- 查询方法以find | read | get开头；
- 涉及查询条件时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写。
- 使用@Query注解可以自定义JPQL语句实现更灵活的查询。

### CrudRepository接口

CrudRepository 接口提供了最基本的对实体类的添删改查操作。

- Tsave(T entity);//保存单个实体   
- Iterable<T> save(Iterable<?extends T> entities);//保存集合        
- T findOne(ID id);//根据id查找实体         
- boolean exists(ID id);//根据id判断实体是否存在         
- Iterable<T> findAll();//查询所有实体,不用或慎用!         
- long count();//查询实体数量         
- void delete(ID id);//根据Id删除实体         
- void delete(T entity);//删除一个实体   
- void delete(Iterable<? extends T> entities);//删除一个实体的集合         
- void deleteAll();//删除所有实体,不用或慎用!   

### PagingAndSortingRepository接口

该接口提供了分页与排序功能  。

- Iterable<T> findAll(Sort sort); //排序    
- Page<T> findAll(Pageable pageable); //分页查询（含排序功能）

### JpaRepository接口

查找所有实体，排序；查找所有实体，执行缓存与数据库同步

### JpaSpecificationExecutor接口

不属于Repository体系，实现一组 JPA Criteria 查询相关的方法，封装  JPA Criteria 查询条件。通常使用匿名内部类的方式来创建该接口的对象。





个人博客：http://taoweidong.com/

GitHub源码地址：https://github.com/TaciturnK/springboot-learning