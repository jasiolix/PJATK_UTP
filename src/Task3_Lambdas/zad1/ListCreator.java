package Task3_Lambdas.zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

 class ListCreator<TIn> {
    private List<TIn> listIn;
    public ListCreator(List<TIn> listIn) {
        this.listIn = listIn;
    }
    public static<TIn> ListCreator<TIn> collectFrom(List<TIn> list){
        return new ListCreator<TIn>(list);
    }

    public ListCreator<TIn> when(Predicate<TIn> predicate){
        List<TIn> listOut = new ArrayList<TIn>();
        for(TIn el : listIn){
            if(predicate.test(el)) {
                listOut.add(el);
            }
        }
        listIn = listOut;
        return this;
    }

    public <TOut> List<TOut> mapEvery(Function<TIn,TOut> function){
        List<TOut> listOut = new ArrayList<TOut>();
        for(TIn el : listIn){
            listOut.add(function.apply(el));
        }
        return listOut;
    }
}
