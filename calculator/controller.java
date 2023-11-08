package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class controller {
    @FXML
    private TextField display;
    @FXML
    private Button clear;

    @FXML
    private Button divide;

    @FXML
    private Button dot;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button multiply;

    @FXML
    private Button negate;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button percent;

    @FXML
    private Button plus;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button subtract;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    double result = 0;
    double num1 = 0;
    double num2 = 0;
    int dotCount = 0;
    char operator;
    boolean errorState = false;

    @FXML
    private void calculate(ActionEvent event)
    {
        if (errorState)
        {
            display.setText("");
            errorState = false;
        }
        if (event.getSource() == zero)
        {
            display.appendText("0");
        }
        else if (event.getSource() == one)
        {
            display.appendText("1");
        }
        else if(event.getSource() == two)
        {
            display.appendText("2");
        }
        else if(event.getSource() == three)
        {
            display.appendText("3");
        }
        else if(event.getSource() == four)
        {
            display.appendText("4");
        }
        else if(event.getSource() == five)
        {
            display.appendText("5");
        }else if(event.getSource() == six)
        {
            display.appendText("6");
        }else if(event.getSource() == seven)
        {
            display.appendText("7");
        }else if(event.getSource() == eight)
        {
            display.appendText("8");
        }
        else if(event.getSource() == nine)
        {
            display.appendText("9");
        }
        else if(event.getSource() == dot && dotCount == 0)
        {
            display.appendText(".");
            dotCount = 1;
        }
        else if(event.getSource() == plus)
        {
            num1 = Double.parseDouble(display.getText());
            display.setText("");
            operator = '+';
            dotCount = 0;
        }
        else if(event.getSource() == subtract)
        {
            num1 = Double.parseDouble(display.getText());
            display.setText("");
            operator = '-';
            dotCount = 0;
        }
        else if(event.getSource() == multiply)
        {
            num1 = Double.parseDouble(display.getText());
            display.setText("");
            operator = 'x';
            dotCount = 0;
        }
        else if(event.getSource() == divide)
        {
            num1 = Double.parseDouble(display.getText());
            display.setText("");
            operator = '/';
            dotCount = 0;
        }
        else if(event.getSource() == negate)
        {
            num1 = Double.parseDouble(display.getText());
            num1 *= -1;
            if (num1 == (int) num1)
            {
                display.setText(String.valueOf((int) num1));
            }
            else
            {
                display.setText(String.valueOf(num1));
            }
            dotCount = 0;
        }
        else if (event.getSource() == percent)
        {
            num1 = Double.parseDouble(display.getText());
            num1 /= 100;
            display.setText(String.valueOf(num1));
        }
        else if (event.getSource() == clear)
        {
            num1 = 0;
            num2 = 0;
            operator = ' ';
            dotCount = 0;
            display.setText("");
        }
        else if(event.getSource() == equal)
        {
            num2 = Double.parseDouble(display.getText());
            if (operator == '+')
            {
                result = num1 + num2;
            }
            else if (operator == '-')
            {
                result = num1 - num2;
            }
            else if (operator == 'x')
            {
                result = num1 * num2;
            }
            else if (operator == '/')
            {
                result = num1 / num2;
            }
            if (Double.isNaN(result) || Double.isInfinite(result))
            {
                display.setText("Math error");
                errorState = true;
                num1 = 0;
                num2 = 0;
            }
            else if (result == (int) result)
            {
                display.setText(String.valueOf((int) result));
            }
            else
            {
                display.setText(String.valueOf(result));
            }
            dotCount = 1;
        }
    }

}
