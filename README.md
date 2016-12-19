# sbiger-jpa-qbe
Java Persistence API(JPA) on Query By Example(QBE)  
**Base on Spring Data JPA**

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
        Example<User> example = new Example<User>();
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


