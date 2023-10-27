package Task2_Generics;

import java.util.ArrayList;
import java.util.List;

class ListCreator<TIn, TOut> {
    private List<TIn> listIn;
    public ListCreator(List<TIn> listIn) {
        this.listIn = listIn;
    }
    public static<TIn,TOut> ListCreator<TIn,TOut> collectFrom(List<TIn> list){
        return new ListCreator<TIn,TOut>(list);
    }

    public ListCreator<TIn,TOut> when(Selector<TIn> selector){
        List<TIn> listOut = new ArrayList<TIn>();
        for(TIn el : listIn){
            if(selector.select(el)) {
                listOut.add(el);
            }
        }
        listIn = listOut;
        return this;
    }

    public List<TOut> mapEvery(Mapper<TIn,TOut> mapper){
        List<TOut> listOut = new ArrayList<TOut>();
        for(TIn el : listIn){
            listOut.add(mapper.map(el));
        }
        return listOut;
    }
}
