package Project01AdditionaloOperationsOnLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class XList<T> extends ArrayList<T> {
    XList(T... args){
        super(Arrays.asList(args));
    }

    XList(Collection<T> collection){
        super(collection);
    }

    public static<T> XList<T> of(T... args){
        return new XList<>(args);
    }

    public static<T> XList<T> of(Collection<T> collection){
        return new XList<>(collection);
    }


    public static XList<String> charsOf(String string) {
        return new XList<String>(string.toCharArray());
    }

    public static XList<String> tokensOf(String string, String... sep) {
    }
}
