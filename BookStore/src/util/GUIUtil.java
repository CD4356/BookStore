package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUtil {

    //设置图片存放目录

    //给按钮设置图标和文本以及提示文字
    public static void setImageIcon(JButton b, String imgFolder, String tip) {
        //获取图标对象
        ImageIcon icon = new ImageIcon(new File(imgFolder).getAbsolutePath());
        //将图标添加到按钮中
        b.setIcon(icon);
        //设置图片按钮文本
        b.setText(tip);
        //设置图片按钮大小
        b.setPreferredSize(new Dimension(51, 56));
        //设置鼠标停留时显示提示信息
        b.setToolTipText(tip);
        //设置文本在图标下方
        b.setVerticalTextPosition(JButton.BOTTOM);
        //设置文本与图标居中对齐
        b.setHorizontalTextPosition(JButton.CENTER);
    }

}
