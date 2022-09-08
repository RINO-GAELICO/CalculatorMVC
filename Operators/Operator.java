package Operators;

import Operand.Operand;

import java.util.HashMap;
import java.util.Map;


public abstract class Operator {
  // The Operators.Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  static Map<String, Operator> operators = new HashMap<>();

  static {

    operators.put( "+", new AdditionOperator() );
    operators.put( "-", new SubtractionOperator() );
    operators.put( "*", new MultiplicationOperator() );
    operators.put( "/", new DivisionOperator() );
    operators.put( "^", new PowerOperator() );
    operators.put( "(", new OpenParenthesisOperator() );
    operators.put( ")", new CloseParenthesisOperator() );

  }

  public abstract int priority();

  public abstract Operand execute(Operand op1, Operand op2 );

  public static boolean check( String token ) {

    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
            || token.equals("^") || token.equals("(") || token.equals(")");
  }

  public static Operator retrieveOperator ( String token ){

    return operators.get(token);
  }

}
