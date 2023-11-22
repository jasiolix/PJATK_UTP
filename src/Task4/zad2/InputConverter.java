package Task4.zad2;

import java.util.function.Function;

class InputConverter<T> {

    private final T fname;

    public InputConverter(T fname) {
        this.fname = fname;
    }


    public <R> R convertBy(Function<?,?>... functions) { //Function means we declare that functions can be of any generic type Function<..., ...>
        Object res = fname; //Be default T is bound to class Object
        for (Function function : functions)
            res = function.apply(res); // apply takes anything as an argument that extends Object, bc we used raw type Function
        return (R) res;
    }
}

/*
 raw type Function: more flexible code typing (bc we can create only one convertBy method for any number of any functions), because compiler doesn't check
 if provided function is able to perform apply on res (e.g. if the function is of generic type Function<String, Integer> (runtime type Function<Object, Object>
 and fname is of runtime type Double, than there would be a runtime error, bc apply(res) wouldn't work). Basically, this convertBy method is so short to write,
 because we didn't write into it a way for compiler to check if types of functions are correct, which seems a good idea, bc less code is nicer.
 However, this has a serious consequence - we need to make sure OURSELVES (and generally humans are more error-prone than compilers)
 that the functions we provide will not cause any runtime errors! And we know that the algorithm is totally correct only if it works for ANY correct input data (in our case any function)
 and gives a good result. In this case correct input data (according to compiler) is any Function, but we know that it should be only functions "that make sense"...
*/


