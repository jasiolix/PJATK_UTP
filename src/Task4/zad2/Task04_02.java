package Task4.zad2;

import java.util.function.Function;

class Task04_02 {

    public static void main(String[] args) {
        method("str1", "str2", "str3");
//        method({"str1", "str2", "str3"});

        MyExampleFunctionalInterface varMEFI = ()->{};

        method(
            () -> {},
            () -> {},
            () -> {},
            varMEFI
        );
    }


    public static void method(Function<Object, Object>... functions) {
        for(Function function : functions)
            function.apply("");
    }

    public static void method(MyExampleFunctionalInterface... myFI) {
        for(MyExampleFunctionalInterface mefi : myFI)
            mefi.fun();
    }

    public static void method(String... strings){
        for(String s : strings)
            System.out.println(s);
    }
}
