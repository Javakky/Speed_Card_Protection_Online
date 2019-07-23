package scptcg.annotation;

import scptcg.game.card.Clazz;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface SubClazz {
    Clazz[] value();
}
