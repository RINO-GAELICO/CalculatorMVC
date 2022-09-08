import Operand.Operand;
import Operators.CloseParenthesisOperator;
import Operators.OpenParenthesisOperator;
import Operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {

  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
    String token;
    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));

        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            System.exit( 1 );
          }

          Operator newOperator = Operator.retrieveOperator( token );

          if ( operatorStack.isEmpty() ) {
            operatorStack.push( newOperator );
          } else if ( newOperator instanceof CloseParenthesisOperator ) {
            while ( !(operatorStack.peek() instanceof OpenParenthesisOperator) ) {
              processingTokens( operatorStack.pop() );
            }
            //to get rid of open parenthesis
            operatorStack.pop();

          } else if ( newOperator instanceof OpenParenthesisOperator ) {
            operatorStack.push( newOperator );

          } else {
            while ( !operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority() ) {
              processingTokens( operatorStack.pop() );
            }
            operatorStack.push( newOperator );

          }

        }
      }
    }

    return emptyTheStack();
  }

  private int emptyTheStack(){

    do{
      processingTokens( operatorStack.pop() );
    }while( !operatorStack.isEmpty() );

    return operandStack.peek().getValue();
  }

  private void processingTokens( Operator operator ){

    Operand op2 = operandStack.pop();
    Operand op1 = operandStack.pop();
    operandStack.push( operator.execute( op1, op2 ));
  }

}
