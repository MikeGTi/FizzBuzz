import java.util.ArrayList;

//package FizzBuzz;

public class Main {
    public static void main(String args[]) {
        final int max_num = 100;
        for (int i = 0; i < max_num; i++) {
            System.out.println("Hello world!");
        }
    }

    abstract static class Condition {
        public abstract boolean isTruthy(int num);
    }

    public static class Printer {
        private String context;

        Printer(String _context) {
            this.context = _context;
        }

        void Print() {
            /*String[] lines = context.split("\n");
            for(String line : lines){
                System.out.println(line);
            }*/
            System.out.print(context);
        }
    }
}
    abstract class Strategy implements ITruthy {
        public abstract Boolean isTruthy();
        /* extends Strategy */
    }
    interface ITruthy{
        Boolean isTruthy(int num);
    }

class Tag{
    private String value;

    Tag(String _value ) {
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }
    public void setValue(String _value) { this.value = _value; }
}

class DividerCondition implements ITruthy {
    private int divider;

    DividerCondition(int _divider) {
        this.divider = _divider;
    }

    @Override
    public boolean isTruthy(int num) {
        return ((num % this.divider) == 0);
    }
}

class AndStategy implements ITruthy {
    private ArrayList<ITruthy> conditionsOrStrategies = new ArrayList();
    AndStategy() {
        this.conditionsOrStrategies = _conditionsOrStrategies;
    }
    @Override
    public Boolean isTruthy(int num) {
        for(ITruthy item1 : conditionsOrStrategies){
            if (!item1.isTruthy(num)) {
                return false;
            }
        }
        return true;
    }

}
class TagNumRule {
    private Tag tag = new Tag();
    private AndStategy strategy = new AndStategy();
    TagNumRule(String _tag, AndStategy _strategy){
        this.tag = _tag;
        this.strategy = _strategy;
    }
    Boolean isSuccess(int num){
        return this.strategy.isTruthy(num);
    }
}
