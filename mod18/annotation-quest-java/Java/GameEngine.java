
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

    public static void useSkill(Object character, String methodName) throws Exception{

        Method method = character.getClass().getDeclaredMethod(methodName);

        if(method.isAnnotationPresent(Skill.class)){
            Skill skill = method.getAnnotation(Skill.class);

            Method getMana = character.getClass().getMethod("getMana");
            int heroMana = (int) getMana.invoke(character);

            System.out.printf("Preparing to use %s", skill.name());

            if (heroMana >= skill.manaCost()){

                method.invoke(character);

                Method setMana = character.getClass().getMethod("setMana", int.class);
                setMana.invoke(character,heroMana - skill.manaCost());

                System.out.printf("Mana: %d.", (heroMana- skill.manaCost()));

            } else {

                System.out.printf("There's no enough mana for %s.", skill.name());

            }

        }

    }

}
