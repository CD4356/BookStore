package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Welcome extends JFrame {

    ImageIcon img=new ImageIcon("img/CD4356.jpg");
    private JLabel imglabel=new JLabel(img);

    JPanel btnPanel=new JPanel();
    private JLabel usernamelabel=new JLabel("账号:");
    private JTextField username=new JTextField(8);
    private JLabel userpasslabel=new JLabel("密码:");
    private JTextField userpass=new JTextField(8);
    private JButton btn=new JButton("登陆");
    private JLabel report=new JLabel();

    public Welcome(){
        this.init();
        this.addComponent();
        this.addListener();
    }

    // 初始化窗口
    private void init(){
        this.setTitle("学而乐书店");
        this.setSize(600,410);

        // 设置窗口标题图标
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("img/titleIcon.jpg");
        this.setIconImage(icon);

        // 设置窗口再显示器居中显示，还可以使用this.setLayout(null);方式设置窗口居中
        Dimension screenSize =toolkit.getScreenSize();
        int x=(screenSize.width-this.getWidth())/2;
        int y=(screenSize.height-this.getHeight())/2;
        this.setLocation(x,y);

        // 设置窗口大小不可变
        this.setResizable(false);
        // 设置单击窗口右上角×时，默认为结束项目运行
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 为窗口添加组件
    private void addComponent() {
        imglabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        this.add(imglabel,BorderLayout.NORTH);

        btnPanel.setLayout(null);
        usernamelabel.setBounds(40,17,50,28);
        usernamelabel.setFont(new Font("隶书", Font.PLAIN, 20));
        username.setBounds(100,17,150,28);
        userpasslabel.setBounds(265,17,50,28);
        userpasslabel.setFont(new Font("隶书", Font.PLAIN, 20));
        userpass.setBounds(325,17,150,28);
        btn.setBackground(Color.lightGray);
        btn.setBounds(500,16,60,30);
        btnPanel.add(usernamelabel);
        btnPanel.add(username);
        btnPanel.add(userpasslabel);
        btnPanel.add(userpass);
        btnPanel.add(btn);

        report.setBounds(200,50,200,20);

        report.setFont(new Font("隶书", Font.PLAIN, 20));
        report.setText("账号密码默认为123！");
        report.setForeground(Color.red);
        btnPanel.add(report);
        this.add(btnPanel);
    }

    // 为按钮设置监听器
    private void addListener() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.getText().equals("123") && userpass.getText().equals("123")){
                    showBookAdmin();
                    // 进入JDialog管理界面后，关闭JFrame窗口
                    dispose();
                }else{
                    report.setText("账号或密码错误！");
                    username.setText("");
                    userpass.setText("");
                }
            }
        });
    }

    public abstract void showBookAdmin();

}
