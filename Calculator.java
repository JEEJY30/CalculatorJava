
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{

  JFrame frame;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[9];
  JButton addButton, subButton, mulButton, divButton;
  JButton decButton, equButton, delButton, clrButton, negButton;
  JPanel panel;
  
  Font myFont = new Font("SansSerif", Font.BOLD,30);

  double num1 = 0, num2 = 0, result = 0;
  char operator;

  Calculator()
  {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(myFont);
    textField.setEditable(false);
   
    functionButtons[0] = new JButton("+");
    functionButtons[1] = new JButton("-");
    functionButtons[2] = new JButton("x");
    functionButtons[3] = new JButton("/");
    functionButtons[4] = new JButton(".");
    functionButtons[5] = new JButton("=");
    functionButtons[6] = new JButton("Delete");
    functionButtons[7] = new JButton("Clear");
    functionButtons[8] = new JButton("(-)");

    for(int i = 0; i < 9; i++)
    {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    for(int i = 0; i < 10; i++)
    {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }
    negButton.setBounds(50, 430, 100, 50);
    delButton.setBounds(150, 430,100,50);
    clrButton.setBounds(250, 430,100,50);

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4,4,10,10));
    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);


    frame.add(negButton);
    frame.add(panel);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textField);
    frame.setVisible(true);
  }
  public static void main(String[] args)
  {
    Calculator calc = new Calculator();
    calc.toString();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    
    for(int i = 0; i < 10; i++)
    {
      if(e.getSource() == numberButtons[i])
      {
          textField.setText(textField.getText().concat(String.valueOf(i)));
      }
    }
    if(e.getSource() == decButton)
    {
      textField.setText(textField.getText().concat(String.valueOf(".")));
    }
    if(e.getSource() == addButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          num1 = Double.parseDouble(textField.getText());
          operator = '+';
          textField.setText("");
        }
    }
    if(e.getSource() == subButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          num1 = Double.parseDouble(textField.getText());
          operator = '-';
          textField.setText("");
        }
    }
    if(e.getSource() == mulButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          num1 = Double.parseDouble(textField.getText());
          operator = 'x';
          textField.setText("");
        }
    }
    if(e.getSource() == divButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          num1 = Double.parseDouble(textField.getText());
          operator = '/';
          textField.setText("");
        }
    }
    if(e.getSource() == equButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          num2 = Double.parseDouble(textField.getText());
    
          switch(operator)
          {
            case'+':
              result = num1 + num2;
              break;
            case'-':
              result = num1 - num2;
              break;
            case'x':
              result = num1 * num2;
              break;
            case'/':
              result = num1 / num2;
              break;
          }
          textField.setText(String.valueOf(result));
          num1 = result;
        }
    }
    if(e.getSource() == clrButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          textField.setText("");
        }
    }
    if(e.getSource() == delButton)
    {
      String text = textField.getText();
      if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          String string = textField.getText();
          textField.setText("");
          for(int i = 0; i < string.length() - 1; i++)
          {
            textField.setText(textField.getText() + string.charAt(i));
          }
        }
    }
    if(e.getSource() == negButton)
    { 
      String text = textField.getText();
        if(text == null || text.isEmpty() || text.equals("0"))
        {
          System.out.println("Empty or 0. Please first write a non-zero number");
        }
        else
        {
          double temp = Double.parseDouble(text);
          temp *= -1;
          textField.setText(String.valueOf(temp));
        }
    }
  }

}
