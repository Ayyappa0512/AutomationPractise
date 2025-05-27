import java.util.*;

public class Practise {

    public static void main(String[] args) {
//        System.out.println("Character Count program");
//        String s = "DevLabsAlliance";
//        Map<Character, Integer> chCount = characterCountOfAString(s);
        //get()
        //put()
        //entrySet()
        //keySet()
        //values()
        //size()
        //Map.Entry<K,V>
        //put(K, V), PutAll(map<k, v)),  remove(), removeAll()
        //forEach loop BiConsumer -> lambda expression
//        chCount.forEach((k,v) ->{
//            if(v > 1)
//                System.out.println("key: "+k+" Value: "+v);
//        });
//        System.out.println(chCount);
//        for(Map.Entry<Character, Integer> entry:chCount.entrySet() ){
//            System.out.println("Entry: "+entry);
//            System.out.println("key: "+entry.getKey());
//            System.out.println("Value: "+entry.getValue());
//        }

        //List functions
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number :");
        int number = scanner.nextInt();
        System.out.println("Enter string :");
        Scanner s2 = new Scanner(System.in);
        String s = s2.nextLine();
//        isPrimeNumber(number);
//        fibonacciSeries(number);
//        System.out.println(factorial(number));
//        factorialWithoutRecursive(number);
//        isPalindromeString(s);
        reverseStringWithoutStringBuilder(s);

    }

    public static Map<Character, Integer> characterCountOfAString(String inputString){
        String s = "DevLabsAlliance";
        char[] ch = s.toCharArray();
        Map<Character, Integer> chCount = new HashMap<>();
        for(int i=0; i<ch.length; i++){
            if(chCount.keySet().contains(ch[i])){
                chCount.put(ch[i], chCount.get(ch[i])+1);
            }
            else{
                chCount.put(ch[i], 1);
            }
        }
        return chCount;
    }

    public static void isPrimeNumber(int number){
        boolean isPrime = true;
        if(number<= 1){
            isPrime = false;
        }else {
           for(int i=2; i<number/2; i++){
               if(number%i == 0){
                   isPrime = false;
               }
           }
        }
        if(isPrime){
            System.out.println("The given number "+number+" is a prime");
        }else {
            System.out.println("The given number "+number+" is not a prime");
        }
    }

    public static void fibonacciSeries(int number){
        int first = 0;
        int second  = 1;

        for(int i=0; i <= number; i++){
            System.out.print(first +" ");
            int next  = first +second;
            first = second;
            second = next;
        }

    }

    public static int factorial(int number){
        if(number <=1){
            return 1;
        }else{
            return number*factorial(number-1);
        }
    }

    public static void factorialWithoutRecursive(int number){
        int result=1;
        if(number<= 1){
            System.out.println("factorial of "+number+" is: "+result);
        }else {
            for (int i = 1; i <= number; i++) {
                result = result * i;
            }
            System.out.println("factorial of "+number+" is: "+result);
        }

    }

    public static void isPalindromeString(String s){
        StringBuilder sb = new StringBuilder(s);

        String revs = String.valueOf(sb.reverse());
        if(s.equalsIgnoreCase(revs)){
            System.out.println("Given string '"+s+"' is a palindrome");
        }else {
            System.out.println("Given string '"+s+"' is not palindrome");
        }
    }

    public static void reverseStringWithoutStringBuilder(String s){
        char[] ch = s.toCharArray();
        String revs = "";
        for(int i =ch.length-1; i>=0;i--){
            revs = revs.concat(String.valueOf(ch[i]));
        }
        System.out.println(revs);
    }
}
