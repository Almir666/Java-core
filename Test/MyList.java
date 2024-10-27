package Test;

public class MyList<T> {

    private Node<T> head;
    private int size;
  
    public MyList(){
      size = 0;
    }
  
    public boolean isEmpty(){
      return head == null;
    }
  
    public void add(T element) {
      if(isEmpty()) {
        head = new Node<>(element);
      } else {
        Node<T> current = head;
        while(current.next != null) {
          current = current.next;
        }
        Node<T> newNode = new Node<>(element);
        current.next = newNode;
        newNode.prev = current;
      }
      size++;
    }
  
    
    public T get(int index) {
      if(isEmpty()) {
        throw new RuntimeException("Invalid index");
      }
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Invalid index: " + index);
      }
      Node<T> current = head;
      while (index > 0) {
        current = current.next;
        index--;
      }  
      return current.val;
    }
    //  
    // null <- [] <- -> [] <- -> [] <- -> [] <- -> [] -> null;
    public void addFirst(T val) {
      if(isEmpty()){
        head = new Node<>(val);
      } else {
        Node<T> newNode = new Node<>(val);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
      }
      size++;
    }
  
    public void addLast(T val){
      add(val);
    }
  
    public boolean contains(T element) {
      if (isEmpty()) {
        return false;
      }
      else {
        Node<T> current = head;
        while(current.next != null) {
          if(current.val.equals(element)) {
            return true;
          }
          current = current.next;
        }
      }
      return false;
      
    }
  
    public int size() {
      return size;
    }
  
    public void remove(int index) {
      if(isEmpty()) {
        throw new RuntimeException("Invalid index");
      }
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Invalid index: " + index);
      }
      Node<T> current = head;
      while(index > 0) {
        current = current.next;
        index--;
      }
      if(current.next == null){
        current.prev.next = null;
      } else {
        current.prev.next = current.next;
        current.next.prev = current.prev;
      }
      size--;
    }
  
    public void printList(){
      if(isEmpty()) {
        return;
      }
      Node<T> current = head;
      System.out.print(" " + current.val + " ");
      while(current.next != null){
        current = current.next;
      System.out.print(" " + current.val + " ");
      }
      System.out.println();
    }
  
  
  
    
    
    static class Node<T> {
      Node<T> next;
      Node<T> prev;
      T val;
      
      public Node(Node<T> next, Node<T> prev, T val) {
        this.next = next;
        this.prev = prev;
        this.val = val;
      }
  
      public Node(T val) {
        this.val = val;
      }
    }
  
    
      public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.remove(1);
        list.addFirst(4);
        list.printList();
      }
      
  }
