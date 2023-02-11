package task_3_files.refactorAddLogger;

import loggers.configs.JUL;
import task_3_files.Calculator_src_hw1.GUI;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JULcalculator extends GUI {
    Integer LastValue = null;
    String operation = null;

    Logger loggerJUL = null;

    public JULcalculator() {
        super();

        try {
            loggerJUL = JUL.init(JULcalculator.class, "src/task_3_files/refactorAddLogger/logsOutput/julOutput", Level.ALL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    boolean saveFirstValue() {
        Integer integer = this.checkIntValue();
        if (integer == null) {
            super.inputArea.setText("Error");
            loggerJUL.log(Level.INFO, "Пользователь вводит неверные данные");
            return false;
        }

        this.LastValue = integer;
        return true;
    }

    @Override
    public void plus() {
        if (!this.saveFirstValue()) return;
        operation = new Object() {
        }.getClass().getEnclosingMethod().getName();
    }

    @Override
    public void minus() {
        if (!this.saveFirstValue()) return;
        operation = new Object() {
        }.getClass().getEnclosingMethod().getName();
    }

    @Override
    public void division() {
        if (!this.saveFirstValue()) return;
        operation = new Object() {
        }.getClass().getEnclosingMethod().getName();
    }

    @Override
    public void multiply() {
        if (!this.saveFirstValue()) return;
        operation = new Object() {
        }.getClass().getEnclosingMethod().getName();
    }


    @Override
    public void clear() {
        this.LastValue = null;
        super.inputArea.setText("");
    }

    @Override
    public void result() {
        int result = 0;
        Integer secondVal = checkIntValue();
        if (secondVal == null) {
            super.inputArea.setText("Error");
            loggerJUL.log(Level.INFO, "Пользователь вводит неверные данные");
            return;
        }

        if (this.operation.equals("plus")) result = this.LastValue + secondVal;
        if (this.operation.equals("minus")) result = this.LastValue - secondVal;
        if (this.operation.equals("division")) result = this.LastValue / secondVal;
        if (this.operation.equals("multiply")) result = this.LastValue * secondVal;

        super.inputArea.setText(String.valueOf(result));

        this.LastValue = null;
    }


    Integer checkIntValue() {
        try {
            Integer integer = Integer.parseInt(super.inputArea.getText());
            return integer;
        } catch (Exception e) {
            loggerJUL.log(Level.CONFIG, "Не парсится ввод пользователся", e);
            return null;
        }
    }

    @Override
    public void onAnyButtonClickListener() {
        inputArea.requestFocusInWindow();
    }

    @Override
    public void afterPushedButtonListener(ActionEvent e) {
        if (e.getActionCommand().equals("=")) return;

        this.inputArea.setText("");
    }

}