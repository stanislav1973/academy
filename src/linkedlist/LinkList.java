package linkedlist;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertLink(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public Link find(int key) {
        Link current = first;
        while(current.iData != key) {
            if(current.next == null) {
                return null;
            }
            else {
                current = current.next;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertLink(22, 22.3);
        theList.insertLink(44, 4.99);
        theList.insertLink(66, 6.99);
        theList.insertLink(88, 8.99);
        theList.displayList();
        Link f = theList.find(1);
        if(f != null) {
            System.out.print("Fount link with key " + f.iData);
        }
        else {
            System.out.print("Can`t fint link");
        }
    }
}
