package Task2_Generics;

interface Mapper<TIn,TOut> {
    TOut map(TIn arg);
}
