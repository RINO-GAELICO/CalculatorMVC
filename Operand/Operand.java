package Operand;

public class Operand {

  private int OperandValue;

  public Operand(String token) {
    try {
      this.OperandValue = Integer.parseInt( token );
    } catch ( Exception exception ) {
      System.out.println( exception.getMessage() );
    }

  }

  public Operand(int value) {
    this.OperandValue = value;
  }

  public int getValue() {
    return OperandValue;
  }

  public static boolean check(String token) {

    try{
      Integer.parseInt( token );
      return true;
    }catch( NumberFormatException exception ){
      return false;
    }

  }

  @Override
  public String toString(){
    return "" + this.getValue();
  }

}
