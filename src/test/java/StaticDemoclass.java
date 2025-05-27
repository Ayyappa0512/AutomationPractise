public class StaticDemoclass {

    public StaticDemoclass(){
        System.out.println("constructor");
    }
    static {
        System.out.println("Static block");
    }
    public static void main(String[] args) {
        System.out.println("Main");
        StaticDemoclass obj = new StaticDemoclass();
    }

    public static void main3(String[] args) {
        System.out.println("Main 1");
    }
}
