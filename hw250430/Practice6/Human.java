package hw250430.Practice6;

interface Human {
    static void echo() {
        System.out.println("야호!!!");
    }

  
    default void print() {
        System.out.println("인간입니다.");
    }
    void eat();
}
