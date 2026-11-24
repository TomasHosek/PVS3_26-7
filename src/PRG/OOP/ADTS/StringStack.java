package PRG.OOP.ADTS;

public class StringStack implements MyStack {

    String[] data;
    int stackTop;

    private static final int BASE_SIZE = 17;

    public StringStack() {

        data = new String[BASE_SIZE];
        stackTop = 0;
    }

    private void expandArray() {

        String[] newStack = new String[(int) (data.length * 1.5)];

        for (int i = 0; i < data.length; i++) {

            newStack[i] = data[i];
        }

        data = newStack;
    }

    @Override
    public void load(String bullet) {

        data[stackTop] = bullet;
        stackTop++;
    }

    @Override
    public String pop() {

        if (stackTop == 0) {

            return null;
        }

        String casing = data[stackTop-1];
        stackTop--;
        return casing;
    }

    @Override
    public String peek() {

        if (isEmpty()) {

            return null;
        }

        return data[stackTop - 1];
    }

    @Override
    public boolean isEmpty() {

        return stackTop == 0;
    }

    static void main() {

        StringStack stack = new StringStack();
        stack.load("1");
        stack.load("2");
        System.out.println(stack.peek());
        stack.load("3");
        stack.load("4");
        stack.load("5");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}