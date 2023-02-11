package task_3_files.Calculator_src_hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class GUI {
    JFrame jFrame = null;

    public JTextArea inputArea;

    public GUI() {
        inputArea = new JTextArea("");
        this.jFrame = new JFrame("Calculator");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(inputArea);
        inputArea.setMaximumSize(new Dimension(120, 100));

        buttonsGenerate(panel);


        this.jFrame.add(panel);
        this.jFrame.setSize(200, 300);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setVisible(true);
    }

    public void plus() {
    }

    public void minus() {
    }

    public void division() {
    }

    public void multiply() {
    }

    public void result() {
    }

    public void clear() {
    }

    void buttonsGenerate(JPanel panelMain) {
        GUI context = this;
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] namesButtons = {"Plus", "Minus", "Division", "Multiply", "Result", "Clear"};

        for (String nameButton : namesButtons) {
            panel.add(shortButtonsGen(nameButton, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Method methodDecl = context.getClass().getDeclaredMethod(nameButton.toLowerCase());
                        methodDecl.invoke(context); // pass args
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    afterPushedButtonListener(e);
                }
            }));
        }

        for (Component component : panel.getComponents()) {
            try {
                if (((JButton) component).getText().equals("Result")) ((JButton) component).setText("=");
            } catch (Exception e) {
            }
        }

        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onAnyButtonClickListener();
                    }
                });
            }
        }

        panelMain.add(panel);
        return;
    }

    private JButton shortButtonsGen(String nameButton, ActionListener actionListener) {
        JButton button = new JButton(nameButton);
        button.addActionListener(actionListener);
        return button;
    }

    public void onAnyButtonClickListener() {
    }

    public void afterPushedButtonListener(ActionEvent e) {
        new String();
    }


}