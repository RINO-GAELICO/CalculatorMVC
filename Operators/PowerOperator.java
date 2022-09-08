package Operators;
import Operand.Operand;

public class PowerOperator extends Operator {

    private final int PRIORITY_NUM = 4;

    @Override
    public int priority() {
        return PRIORITY_NUM;
    }

    @Override
    public Operand execute( Operand op1, Operand op2 ) {
        return new Operand(( int ) Math.pow( op1.getValue(), op2.getValue() ));
    }

    @Override
    public String toString(){
        return "^";
    }
}
