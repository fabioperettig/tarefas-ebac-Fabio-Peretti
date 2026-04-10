import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MagicItem {

    String name();
    int atkBonus() default 0;
    int defBonus() default 0;
    boolean cursed() default false;

}
