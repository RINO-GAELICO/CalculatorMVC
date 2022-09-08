import Operand.Operand;
import Operators.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();
  private String displayedExpression = "" ;
  private Evaluator evaluator = new Evaluator();


  private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };

  private Button[] buttons = new Button[ bText.length ];

  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {

    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

  @Override
  public void actionPerformed(ActionEvent arg0 ) {

    if (arg0.getActionCommand().equals("C")) {
      displayedExpression = "";
      txField.setText(displayedExpression);
    } else if (arg0.getActionCommand().equals("CE")) {
      displayedExpression = displayedExpression.substring(0, displayedExpression.length() - 1);
      txField.setText(displayedExpression);
    } else if (arg0.getActionCommand().equals("=")) {
      try {
        displayedExpression = Integer.toString(evaluator.eval(displayedExpression));
        txField.setText(displayedExpression);
      } catch (ArithmeticException ex) {
        txField.setText(ex.getMessage());
      }
    } else if (Operator.check(arg0.getActionCommand()) || Operand.check(arg0.getActionCommand())) {
      displayedExpression = displayedExpression.concat(arg0.getActionCommand());
      txField.setText(displayedExpression);
    }
  }
}
