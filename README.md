# sbiger-jpa-qbe
Java Persistence API(JPA) on Query By Example(QBE)  
**Base on Spring Data JPA**  

# Features
* Support and/or logic operation
* Support is(Empty/Boolean/Null)
* Support Equal/NotEqual/In/NotIn/Like/NotLike
* Support gt/ge/lt/le/between
* Support join query
* Support group by
* Support custom specification.
* Support pagination  
**more features coming soon……**

# Java Version
```
 jdk build 1.8 or later
```

# How to Use
```java
    @Resource
    UserReponsitory userReponsitory;
    
    /*
    SQL:
        select * from
            user 
        where
            id=1 
            or id=2 
        group by  
            id,  
            name   
        order by  
            id asc,
            name asc 
        limit ?
    */
    public List<User> findAll(){
        Example<User> example = ExampleBuilder.create();
        example.or()
                .andEqual("id", 1)
                .orEqual("id", 2);
        example.groupBy("id","name");
        example.asc("id","name");
        return userReponsitory.findAll(example, new PageRequest(0, 1));
    }
```

# How to Dev
* Test
```
 mvn test
```

* Package
```
 mvn clean
 mvn package
```


