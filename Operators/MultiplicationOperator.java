package Operators;
import Operand.Operand;

public class MultiplicationOperator extends Operator {

    private final int PRIORITY_NUM = 3;

    @Override
    public int priority() {
        return PRIORITY_NUM;
    }

    @Override
    public Operand execute( Operand op1, Operand op2 ) {
        return new Operand( op1.getValue() * op2.getValue() );
    }

    @Override
    public String toString(){
        return "*";
    }
}
