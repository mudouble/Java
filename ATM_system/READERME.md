# 系统架构搭建
## 1.定义一个账户类Account，至少包括（卡号、姓名、性别、密码、每次取现额度）
## 2.定义一个ATM类，用来代表ATM系统，负责提供所有的业务需求，比如：展示ATM的系统欢迎页等
### 系统欢迎页设计：在ATM类设计一个方法start()，方法里负责展示欢迎界面
### 用户开户功能：新增一个账户，也就是往系统的账户集合添加一个账户对象
#### 账户的要求：用户信息包括：姓名、性别、密码、每次取现额度、卡号（卡号由系统生成，要求是8位数字组成且卡号不能重复）
### 用户登录功能：没有对象不允许登录；输入卡号判断是否存在；卡号正确输入密码，判断密码
### 登录成功以后展示操作界面, 退出就是回到欢迎页面，首先要结束当前的操作页面，接着结束调用操作页面的登录页面，结束之后就可以回到调用登录页面的欢迎页面
### 存款和取款：存款更新账户余额即可；取款需要大于等于100块才能取款；判断取款金额是否超出限制以及余额时候足够
## 3. 定义一个测试类Test，负责对我们开发的ATM系统进行测试



# 知识点
## ArrayList：用于管理一组对象；动态数组、元素有序（按索引查找）、允许重复元素、支持泛型（任何类型的对象）（add、get、remove、set、size）
## Scanner 接收用户输入的数据 sc.next()读取第一个单词，读取整行nextLine()
## charAt是String类的一个方法，用于获取字符串中特定索引位置的字符，charAt(0),比如'man', 使用charAt(0)获取到的是m，而对于中文就是男
## startsWith()检查一个字符串是否以指定的前缀prefix开头,返回true或false，subString(bengin, （end）)获取子字符串
## jave中双引号表示字符串：String，单引号表示字符；python当中双引号和单引号并没有严格的区分
## nextInt()是一个方法，int是数据类型，Random，Scanner，ThreadLocalRandom都有nextInt方法
## java的boolean是true和false，这两个是原始的数据类型；python是True和False，这两个是关键字
## java的命名是驼峰，python的命名是蛇形；isActive is_active




# 快捷键 and idea的设置
## sout：System.out.println
## main：生成main方法
## 右键 generate生成构造方法
## control+alt+t 生成循环
## Run界面点击设置图标可以选择Run界面的位置




# 细节
## 这里的com.itheima包是自己创建的，并不是java标准库里面的一部分