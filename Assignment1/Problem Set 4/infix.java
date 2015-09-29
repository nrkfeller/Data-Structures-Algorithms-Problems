class StackOperator
{
    private int maxSize; // size of stack array
    private char[] stackArray;
    private int top; // top of stack
    //--------------------------------------------------------------
    public StackOperator(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new char[maxSize]; // create array
        top = -1; // no items yet
    }
    //--------------------------------------------------------------
    public void push(char j) // put item on top of stack
    {
        stackArray[++top] = j; // increment top, insert item
    }
    //--------------------------------------------------------------
    public char pop() // take item from top of stack
    {
        return stackArray[top--]; // access item, decrement top
    }
    //--------------------------------------------------------------
    public char peek() // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    
    public int getTop()
    {
        return top;
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize-1);
    }
//--------------------------------------------------------------
} // end class StackX
class StackInteger
{
    private int maxSize; // size of stack array
    private int[] stackArray;
    private int top; // top of stack
    //--------------------------------------------------------------
    public StackInteger(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    }
    //--------------------------------------------------------------
    public void push(int j) // put item on top of stack
    {
        stackArray[++top] = j; // increment top, insert item
    }
    //--------------------------------------------------------------
    public int pop() // take item from top of stack
    {
        return stackArray[top--]; // access item, decrement top
    }
    //--------------------------------------------------------------
    public int peek() // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize-1);
    }
//--------------------------------------------------------------
}
////////////////////////////////////////////////////////////////
    class evalInfix
    {
        private StackOperator opStack;
        private StackInteger intStack;
        private String input;
        
        public evalInfix(String in){
            input = in;
            int size = input.length();
            opStack = new StackOperator(size);
            intStack = new StackInteger(size);
           
        }
        
        
        public void evaluator(){
            for(int i = 0; i < input.length(); i++){
                if (Character.isDigit(input.charAt(i))){
                    intStack.push(Character.getNumericValue(input.charAt(i)));
                  
                } else {
                    if ( opStack.isEmpty() ){
                        opStack.push(input.charAt(i));
                     
                    } else {
                        if (evaluateOperator(input.charAt(i)) ){
                            opStack.push(input.charAt(i));
                           
                        } else {
                            //evaluate
                            while (!opStack.isEmpty()){
                                evaluate(opStack.pop());
                            }
                            opStack.push(input.charAt(i));
                       
                        }
                    }
                    
                    
                }
                
            }
            while (opStack.getTop() > -1 ){
                evaluate(opStack.pop());
            }
          
             System.out.println(intStack.peek());
        }

    public boolean evaluateOperator(char operator){
        if (operator == '*' || operator == '/'){
            switch (opStack.peek()) {
                case '+':
                case '-':
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }
    
    public void evaluate(char operator){
        int rightValue = intStack.pop();
        int leftValue = intStack.pop();
        switch (operator){
            case '+':
                intStack.push(leftValue + rightValue);
                break;
            case '-':
                intStack.push(leftValue - rightValue);
                break;
            case '*':
                intStack.push(leftValue * rightValue);
                break;
            case '/':
                intStack.push(leftValue / rightValue);
                break;
        }
    }
    
} // end class StackApp

class prob{
    
    public static void main(String[] args){
        String expression = "3+4*5-6/2";
        
        evalInfix theEval = new evalInfix(expression);
        theEval.evaluator();
    }
}