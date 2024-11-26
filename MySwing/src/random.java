import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class random extends JFrame {
    public School school;
    public JTextArea resultArea;
    public JButton randomClassBtn;
    public JButton randomGroupBtn;
    public JButton randomStudentFromGroupBtn;
    public JButton randomStudentFromClassBtn;

    public random() {
        // 设置窗口基本属性
        setTitle("随机抽取系统");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 初始化数据
        initializeSchoolData();

        // 创建界面组件
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        randomClassBtn = new JButton("随机抽取班级");
        randomGroupBtn = new JButton("随机抽取小组");
        randomStudentFromGroupBtn = new JButton("从小组随机抽取学生");
        randomStudentFromClassBtn = new JButton("从班级随机抽取学生");

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // 添加按钮事件监听器
        randomClassBtn.addActionListener(e -> randomSelectClass());
        randomGroupBtn.addActionListener(e -> randomSelectGroup());
        randomStudentFromGroupBtn.addActionListener(e -> randomSelectStudentFromGroup());
        randomStudentFromClassBtn.addActionListener(e -> randomSelectStudentFromClass());

        // 添加组件到面板
        buttonPanel.add(randomClassBtn);
        buttonPanel.add(randomGroupBtn);
        buttonPanel.add(randomStudentFromGroupBtn);
        buttonPanel.add(randomStudentFromClassBtn);

        // 设置布局
        setLayout(new BorderLayout(10, 10));
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // 添加边距
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void initializeSchoolData() {
        school = new School();
        Class c1 = new Class("1班");
        Class c2 = new Class("2班");
        Group g1 = new Group("1组");
        Group g2 = new Group("2组");
        Group g3 = new Group("3组");
        Group g4 = new Group("4组");
        Group g5 = new Group("5组");
        Group g6 = new Group("6组");
        Student s1 = new Student("A");
        Student s2 = new Student("B");
        Student s3 = new Student("C");
        Student s4 = new Student("D");
        Student s5 = new Student("E");
        Student s6 = new Student("F");
        Student s7 = new Student("G");
        Student s8 = new Student("H");
        Student s9 = new Student("I");
        Student s10 = new Student("J");
        Student s11 = new Student("K");
        Student s12 = new Student("L");
        school.classes[0] = c1;
        school.classes[1] = c2;
        c1.groups[0] = g1;
        c1.groups[1] = g2;
        c1.groups[2] = g3;
        c2.groups[0] = g4;
        c2.groups[1] = g5;
        c2.groups[2] = g6;
        c1.students[0] = s1;
        c1.students[1] = s2;
        c1.students[2] = s3;
        c1.students[3] = s4;
        c1.students[4] = s5;
        c1.students[5] = s6;
        c2.students[0] = s7;
        c2.students[1] = s8;
        c2.students[2] = s9;
        c2.students[3] = s10;
        c2.students[4] = s11;
        c2.students[5] = s12;
        g1.students[0] = s1;
        g1.students[1] = s2;
        g2.students[0] = s3;
        g2.students[1] = s4;
        g3.students[0] = s5;
        g3.students[1] = s6;
        g4.students[0] = s7;
        g4.students[1] = s8;
        g5.students[0] = s9;
        g5.students[1] = s10;
        g6.students[0] = s11;
        g6.students[1] = s12;
    }

    public void randomSelectClass() {
        Random r = new Random();
        Class c = school.classes[r.nextInt(2)];
        appendResult("随机抽取到的班级为：" + c.name);
    }

    public void randomSelectGroup() {
        Random r = new Random();
        Class c = school.classes[r.nextInt(2)];
        Group g = c.groups[r.nextInt(3)];
        appendResult("随机从" + c.name + "抽到的小组为：" + g.name);
    }

    public void randomSelectStudentFromGroup() {
        Random r = new Random();
        Class c = school.classes[r.nextInt(2)];
        Group g = c.groups[r.nextInt(3)];
        appendResult("随机从" + g.name + "抽到的学生为：" + g.students[r.nextInt(2)].name);
    }

    public void randomSelectStudentFromClass() {
        Random r = new Random();
        Class c = school.classes[r.nextInt(2)];
        appendResult("随机从" + c.name + "抽到的学生为：" + c.students[r.nextInt(6)].name);
    }

    public void appendResult(String text) {
        resultArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            random frame = new random();
            frame.setVisible(true);
        });
    }
}