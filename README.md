学而乐书店管理系统
---
##### 这是一个基于Java GUI的简单的水果管理系统，内容比较简单，主要目的是用于了解JDBC的多层开发模式
###### 该swing项目的除了登陆界面外，还包含4个界面，分别为书籍管理界面，借书记录界面，旧书回收界面和收支帐单界面，它们与工具栏的按钮相互对应。其中除了书籍管理界面的功能实现了之外，其他三个界面都只是假设，还没有任何实现。但这没有关系，书籍管理界面的实现也足够让我们初步认识JDBC的多层开发模式了。

效果图|描述
|----|-----|
![登陆界面](https://github.com/CD4356/BookStore/blob/master/image/wel.jpg "悬停显示")|`登陆界面是一个窗口，该窗口主要分为两部分，北区为图片区，图片放在JLabel组件中。另一个为正文区，主要为两个文本框和一个按钮，用于实现登陆跳转，还有一个JLabel用于显示登陆提示，账号密码错误时，则修改JLabel内容显示输入信息错误提示。`
![书籍管理界面](https://github.com/CD4356/BookStore/blob/master/image/admin.jpg "悬停显示")|`登陆成功后，则会跳转到书籍管理界面，该界面也是一个窗口，使用setBounds()方法来设置组件的位置(使用setBounds()前需setLayout(null)清空布局管理器)，其中JToolBar有四个按钮与4个界面相对应。用于实现界面的切换，JTable表格用于显示数据库中所有书籍的信息，文本框和按钮用来提交书籍的增删改操作，提交失败时，会弹出一个消息对话框来提示错误`



项目结构如下图：


![项目结构](https://github.com/CD4356/BookStore/blob/master/image/jiegou.jpg "悬停显示")


表示层：主要是与用户进行交互，如显示数据和接收用户输入的数据

业务逻辑层：调用Dao基本数据操作来完成业务逻辑，比如：在接收表示层传入的数据后进行逻辑处理后调用Dao基本数据操作来完成该业务逻辑

数据访问层：位于业务逻辑和持久化数据之间，实现对持久化数据的访问

数据层：数据层其实就是数据库所在的层

实体类：实体类可以看成是数据库表的映射，实体类的类名与数据库表的表名相同，属性也与表的字段一一对应，它主要用于存放与传输对象数据

多层开发模式|类之间的关系
|----|-----|
![多层开发模式](https://github.com/CD4356/BookStore/blob/master/image/moshi.jpg "悬停显示")|![类之间的关系](https://github.com/CD4356/BookStore/blob/master/image/guanxi.jpg "悬停显示")
