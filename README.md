# __*DogSelector {javafx}*__

Change __*DBConfig*__ class in *src/main/java/com/example* to add your DataBase properties such that

```
package com.example;

public class DBConfig {
   public final static String URL = "jdbc:postgresql://localhost:{your_port}/{database_exact_name}";
   public final static String NAME = "{db_name}";
   public final static String PASSWORD = "{db_password}";
}
```

# __*Dogacquisition DB*__

__*[dogacquistion.tar](dogacquisition.tar)*__