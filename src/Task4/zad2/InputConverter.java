package Task4.zad2;

import java.util.function.Function;
class InputConverter <T> {

    private T fname;

    public InputConverter(T fname) {
        this.fname = fname;
    }


    public <R> R convertBy(Function... functions) {
        Object res = fname; //Be default T is bound to class Object
        for(Function function : functions)
            res = function.apply(res); //when convertBy(flines) method is called, at this point
        // type of flines was erased, so thats why we are able to pass res (Object type) to it
        // as an argument - downcasting is implicit in this special case. If we tried to invoke
        // flines.apply(obj) in main method, there would be a compilation error, bc compiler
        // would remind us that flines takes String as an argument, not Object.
        return (R) res;
    } // here we provide a raw type Function without specifying generic types. This is
    // an old java notation before Generics, and in this case compiler doesn't check
    // the types of input and output of function.apply() (so functions array can contain
    // any type of Function<T,R> which is in one way bad, bc it leads
    // to runtime errors, but on the other hand it gives us more freedom.


    //Recursive idea:

    //    public <R> R convertBy(Function... functions) {
    //        return rec(functions.length-1, functions);
    //    }
    //
    //    private <R> R rec(int n, Function... functions){
    //        if(n==0)
    //            return (R) functions[0].apply(fname);
    //        return (R) functions[n].apply(rec(n-1,functions));
    //    }
    //


}



