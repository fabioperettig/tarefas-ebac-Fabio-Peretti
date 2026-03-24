/**
 * With this param T tagged in the Class, it's possible to implement
 * attributes and constructors without specify what kind of attribute/param
 * you want it. For this reason, you can instance and obj 'gen1 = new GenericClass(string)'
 * and, with setter, is even possible declare 't1.setData(123)' turning String param into an Integer.
 * -
 * But BEWARE: using this kind of instance, Java will alert you
 * "Raw use of parameterized class 'GenericClass'", suggesting you declare
 * the exactly Type od you Object.
 * -
 * GenericClass t1 = new GenericClass<>(1); [DANGER: RAW TYPE]
 * GenericClass<Integer> t1 = new GenericClass<>(1); [OK]
 *
 * @param <T>
 */
public class GenericClass <T>{

    private T data;

    public GenericClass(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
