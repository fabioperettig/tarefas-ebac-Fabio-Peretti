![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/Custom--Exception-brightgreen?style=for-the-badge)
![Annotation Definition](https://img.shields.io/badge/Annotation-gold?style=for-the-badge)

# 🎮 RPG Metadata Engine: Annotations & Reflection Study

This project is a first deep dive into **Java Annotations**, **Reflection API**, and **Custom Exceptions**. It was chosen a RPG project because it's a perfect theme to demonstrate how metadata can drive clearly it's mechanics.

## 📁 Project Structure

This project follows a modular package structure to separate concerns:

- `annotations/`: Contains custom metadata definitions.
- `engine/`: The core logic using Reflection API.
- `entities/`: Character classes (POJOs) where annotations are applied.
- `exceptions/`: Custom error handling classes.

## 🔗 Quick Links
Check out the main logic here:<br>
- [Annotation Definition](INSERT_LINK_HERE)
- [Reflection Engine](INSERT_LINK_HERE)
- [Custom Exception](INSERT_LINK_HERE)


## 🚀 What I Learned

### 1. Custom Annotations
I created annotations like `@com.fabioperettig.rpg.annotations.Skill` and `@ItemMagico` to tag fields and methods. This allowed me to:
* Define metadata (like mana cost or attack bonus) directly in the source code.
* Use `default` values to keep the code clean when specific data isn't provided.
* Understand the importance of `@Retention(RetentionPolicy.RUNTIME)` to keep metadata accessible during execution.

````java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface com.fabioperettig.rpg.annotations.MagicItem {

    String name();
    int atkBonus() default 0;
    int defBonus() default 0;
    boolean cursed() default false;
}
````

### 2. Reflection API (The "Engine")
This is where the magic happens! I built a `com.fabioperettig.rpg.engine.GameEngine` that doesn't "know" the player classes directly. Instead, it uses Reflection to:
* **Scan Fields:** Read item bonuses to calculate hero stats.<br>

````java

import com.fabioperettig.rpg.annotations.MagicItem;

import java.lang.reflect.Field;

public class com.fabioperettig.rpg.engine.

GameEngine {

    public static void processAnnotations (Object character) throws Exception {
        System.out.println("––– com.fabioperettig.rpg.entities.Hero Status –––");

        int totalAttack = 0;

        for (Field field : character.getClass().getDeclaredFields()) {

            /// checking if there's @magicItem tag
            if (field.isAnnotationPresent(MagicItem.class)) {
                MagicItem item = field.getAnnotation(MagicItem.class);

                System.out.printf("Equipped: %s.\n", item.name());

                if (item.cursed()) {
                    System.out.println("Careful, this item looks cursed!");
                }

                totalAttack += item.atkBonus();

            }

        }

        System.out.printf("Total attack bonus from @Annotations: %d!", totalAttack);
    }

    {...}
}
````
<br>

* **Scan Methods:** Find skills marked with `@com.fabioperettig.rpg.annotations.Skill`.
* **Dynamic Invocation:** Use the `.invoke()` method to execute skills only after validating requirements.<br>

````java
import com.fabioperettig.rpg.annotations.Skill;
import com.fabioperettig.rpg.exceptions.InsuficientManaException;

public static void useSkill(Object character, String methodName) throws InsuficientManaException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Method method = character.getClass().getDeclaredMethod(methodName);

    if (method.isAnnotationPresent(Skill.class)) {
        Skill skill = method.getAnnotation(Skill.class);

        Method getMana = character.getClass().getMethod("getMana");
        int heroMana = (int) getMana.invoke(character);

        System.out.printf("Preparing to use %s", skill.name());


        if (heroMana >= skill.manaCost()) {

            method.invoke(character);

            Method setMana = character.getClass().getMethod("setMana", int.class);
            setMana.invoke(character, heroMana - skill.manaCost());

            System.out.printf("Mana: %d.", (heroMana - skill.manaCost()));
        } else {

            throw new InsuficientManaException("Not enough mana! You need " + skill.manaCost() + ".");
        }
    }
}
````

### 3. Custom Exceptions & Error Handling
To make the engine robust, I replaced simple print statements with a formal error-handling system:
* Created **Custom Exceptions** (e.g., `ManaInsuficienteException`) to represent specific game rules.
* Practiced **Checked Exceptions** management, listing specific errors in the `throws` clause for better transparency.
* Implemented `try-catch` blocks to ensure the game doesn't crash when a rule is broken.

## 🛠️ Tech Stack
* **Language:** Java 17+
* **IDE:** IntelliJ IDEA
* **Concepts:** Metaprogramming, OOP, Exception Handling.

## 📖 How it Works (Snippet)
```java
// Using Reflection to call a skill only if requirements are met
if (heroMana >= skill.manaCost()) {
    method.invoke(character); // Triggering the action!
} else {
    throw new ManaInsuficienteException("Not enough mana!");
}
