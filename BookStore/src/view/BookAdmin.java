package view;

import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BookAdmin extends JFrame {

    public JToolBar toolBar=new JToolBar();
    JButton adminBtn=new JButton();
    JButton lendBtn=new JButton();
    JButton recycleBtn=new JButton();
    JButton billBtn=new JButton();

    private JLabel tableName=new JLabel("图书列表");

    public JScrollPane tablePane=new JScrollPane();
    public JTable table=new JTable();

    private JLabel idLabel=new JLabel("图书编号");
    private JLabel nameLabel=new JLabel("图书名称");
    private JLabel priceLabel=new JLabel("图书单价");
    private JLabel numberLabel=new JLabel("图书余量");

    public JTextField addIdText=new JTextField(6);
    public JTextField addNameText=new JTextField(6);
    public JTextField addPriceText=new JTextField(6);
    public JTextField addNumberText=new JTextField(6);
    private JButton addBtn=new JButton("新增图书");

    public JTextField updateIdText=new JTextField(6);
    public JTextField updateNameText=new JTextField(6);
    public JTextField updatePriceText=new JTextField(6);
    public JTextField updateNumberText=new JTextField(6);
    private JButton updateBtn=new JButton("修改图书");

    public JTextField delIdText=new JTextField(6);
    private JButton delBtn=new JButton("删除图书");


    public BookAdmin() {
        this.init();
        this.addComponent();
        this.addListener();
    }

    // 初始化窗口
    private void init() {
        this.setTitle("学而乐书店");

        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("img/titleIcon.jpg");
        this.setIconImage(icon);

        this.setSize(600,450);
        // 设置窗口大小不可变
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    // 为窗口添加组件
    private void addComponent() {
        //通过GUIUtil类的setImageIcon()方法来设置图片按钮，并传入按钮对象，图片名和鼠标停留的提示信息
        GUIUtil.setImageIcon(adminBtn,"img/book.jpg","书籍管理");
        GUIUtil.setImageIcon(lendBtn,"img/lend.jpg","借书记录");
        GUIUtil.setImageIcon(recycleBtn,"img/recycle.jpg","旧书回收");
        GUIUtil.setImageIcon(billBtn,"img/bill.jpg","收支账单");
        //将按钮添加到工具栏
        toolBar.add(adminBtn);
        toolBar.add(lendBtn);
        toolBar.add(recycleBtn);
        toolBar.add(billBtn);
        toolBar.setBounds(20,0,560,65);
        this.add(toolBar, BorderLayout.NORTH);
        //设置工具栏是否可以移动
        toolBar.setFloatable(true);

        this.setLayout(null);

        tableName.setBounds(250,80,100,25);
        // 设置字体样式
        tableName.setFont(new Font("华文隶书", Font.PLAIN, 23));
        tableName.setForeground(Color.BLACK.brighter());
        this.add(tableName);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setEnabled(false);
        // 使用setBounds()设置组件位置，但使用之前必须setLayout(null)清空布局管理器

        tablePane.setBounds(50,110,500,170);
        tablePane.setViewportView(table);
        this.add(tablePane);

        idLabel.setBounds(50,290,70,25);
        nameLabel.setBounds(150,290,70,25);
        priceLabel.setBounds(250,290,70,25);
        numberLabel.setBounds(350,290,70,25);
        idLabel.setFont(new Font("隶书", Font.PLAIN, 17));
        nameLabel.setFont(new Font("隶书", Font.PLAIN, 17));
        priceLabel.setFont(new Font("隶书", Font.PLAIN, 17));
        numberLabel.setFont(new Font("隶书", Font.PLAIN, 17));
        this.add(idLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(numberLabel);


        addIdText.setBounds(50,320,80,25);
        addNameText.setBounds(150,320,80,25);
        addPriceText.setBounds(250,320,80,25);
        addNumberText.setBounds(350,320,80,25);
        addBtn.setBounds(450,320,100,25);
        this.add(addIdText);
        this.add(addNameText);
        this.add(addPriceText);
        this.add(addNumberText);
        addBtn.setBackground(Color.lightGray);
        addBtn.setFont(new Font("隶书", Font.PLAIN, 16));
        this.add(addBtn);


        updateIdText.setBounds(50,350,80,25);
        updateNameText.setBounds(150,350,80,25);
        updatePriceText.setBounds(250,350,80,25);
        updateNumberText.setBounds(350,350,80,25);
        updateBtn.setBounds(450,350,100,25);
        this.add(updateIdText);
        this.add(updateNameText);
        this.add(updatePriceText);
        this.add(updateNumberText);
        updateBtn.setBackground(Color.lightGray);
        updateBtn.setFont(new Font("隶书", Font.PLAIN, 16));
        this.add(updateBtn);


        delIdText.setBounds(50,380,80,25);
        delBtn.setBounds(450,380,100,25);
        this.add(delIdText);
        delBtn.setBackground(Color.lightGray);
        delBtn.setFont(new Font("隶书", Font.PLAIN, 16));
        this.add(delBtn);

    }

    // 为按钮添加监听器
    private void addListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBook();
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
    }

    //查询方法
    public abstract void queryAll();

    //添加方法
    public abstract void addBook();

    //修改方法
    public abstract void updateBook();

    //删除方法
    public abstract void deleteBook();

}

