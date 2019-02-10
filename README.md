学而乐书店管理系统
===

##### 这是一个基于Java GUI的简单的水果管理系统，内容比较简单，主要目的是让JDBC初学者了解JDBC的多层开发模式

效果图|描述
:----|:-----:
![登陆界面](https://github.com/CD4356/BookStore/blob/master/image/wel.jpg)|登陆界面是一个窗口，该窗口主要分为两部分，北区为图片区，图片放在JLabel组件中。另一个为正文区，主要为两个文本框和一个按钮，用于实现登陆跳转，还有一个JLabel用于显示登陆提示，账号密码错误时，则修改JLabel内容显示输入信息错误提示
![登陆界面](https://github.com/CD4356/BookStore/blob/master/image/admin.jpg)|登陆成功后，则会跳转到书籍管理界面，该界面也是一个窗口，使用setBounds()方法来设置组件的位置(使用setBounds()前需setLayout(null)清空布局管理器)


