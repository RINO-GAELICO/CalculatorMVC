package Operators;
import Operand.Operand;

public class OpenParenthesisOperator extends Operator {

    private final int PRIORITY_NUM = 0;

    @Override
    public int priority() {
        return PRIORITY_NUM;
    }

    @Override
    public Operand execute( Operand op1, Operand op2 ) {
        return null;
    }

    @Override
    public String toString(){
        return "(";
    }
}
