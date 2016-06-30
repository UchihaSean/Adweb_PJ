#高级web后台代码说明

为保证服务器正常运行，请进行如下修改：

- 在 `src/main/java/adweb/Config.java` 中，修改 RESOURCE_FOLDER 为 `server/target/server/WEB-INF/resources/` 的绝对路径，这里是头像等资源的路径。
- 数据库用户名为 `root`，密码为 `123456`。
- 根目录下有 `db.sql`，请导入数据库。

后端开发遵循规范：https://www.zybuluo.com/dugu9sword/note/421826