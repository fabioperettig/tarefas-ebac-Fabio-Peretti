
import java.lang.reflect.Field;

public class GameEngine {

    public static void processAnnotations(Object character) throws Exception{
        System.out.println("––– Hero Status –––");

        int totalAttack = 0;

        for (Field field : character.getClass().getDeclaredFields()) {

            /// checking if there's @magicItem tag
            if(field.isAnnotationPresent(MagicItem.class)){
                MagicItem item = field.getAnnotation(MagicItem.class);

                System.out.printf("Equipped: %s.\n",item.name());

                if (item.cursed()){
                    System.out.println("Careful, this item looks cursed!");
                }

                totalAttack += item.atkBonus();

            }

        }

        System.out.printf("Total attack bonus from @Annotations: %d!", totalAttack);

    }

}
