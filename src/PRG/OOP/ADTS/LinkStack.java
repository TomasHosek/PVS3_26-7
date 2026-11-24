package PRG.OOP.ADTS;

public class LinkStack implements MyStack {

    @Override
    public void load(String bullet) {

    }

    @Override
    public String pop() {
        return "";
    }

    @Override
    public String peek() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

class MyLink {

    public String current;
    public MyLink next;

    public MyLink(String current) {

        this.current = current;
    }

    public void setNext(MyLink next) {

        this.next = next;
    }
}