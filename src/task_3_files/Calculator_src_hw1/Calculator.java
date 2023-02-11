package task_3_files.Calculator_src_hw1;

import java.awt.event.ActionEvent;

public class Calculator extends GUI {
    Integer LastValue = null;
    String operation = null;

    //    JTextArea inp;
    public Calculator() {
        super();
//        super.inputArea=inp;

        new String();
    }


    boolean saveFirstValue() {
        Integer integer = this.checkIntValue();
        if (integer == null) {
            super.inputArea.setText("Error");
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