学而乐书店管理系统
---
##### 这是一个基于Java GUI的简单的图书管理系统
###### 该swing项目的除了登陆界面外，还包含4个界面，分别为书籍管理界面，借书记录界面，旧书回收界面和收支帐单界面，它们与工具栏的按钮相互对应。

效果图|描述
|----|-----|
![登陆界面](https://github.com/CD4356/BookStore/blob/master/image/wel.jpg "悬停显示")|`登陆界面是一个窗口，该窗口主要分为两部分，北区为图片区，图片放在JLabel组件中。另一个为正文区，主要为两个文本框和一个按钮，用于实现登陆跳转，还有一个JLabel用于显示登陆提示，账号密码错误时，则修改JLabel内容显示输入信息错误提示。`
![书籍管理界面](https://github.com/CD4356/BookStore/blob/master/image/admin.jpg "悬停显示")|`登陆成功后，则会跳转到书籍管理界面，该界面也是一个窗口，使用setBounds()方法来设置组件的位置(使用setBounds()前需setLayout(null)清空布局管理器)，其中JToolBar有四个按钮与4个界面相对应。用于实现界面的切换，JTable表格用于显示数据库中所有书籍的信息，文本框和按钮用来提交书籍的增删改操作，提交失败时，会弹出一个消息对话框来提示错误`

<br>

我的博客地址：[https://blog.csdn.net/weixin_42950079/article/details/88533082](https://blog.csdn.net/weixin_42950079/article/details/88533082)
