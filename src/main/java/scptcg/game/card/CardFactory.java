package scptcg.game.card;

import io.github.classgraph.*;

import java.lang.reflect.InvocationTargetException;

public class CardFactory {

    public static Card create(String name, CardCategory category) {
        Class<? extends Card> clazz = category.toClass();
        String packageName = "scptcg.game.card.impl";

        if (Scp.class.isAssignableFrom(clazz)) {
            packageName += ".scp";
        }

        try (ScanResult scanResult = new ClassGraph().enableAllInfo()
                .whitelistPackages(packageName).scan()) {
            String annotationRoot = "scptcg.annotation.Card";
            String valueName = "value";
            ClassInfoList routeClassInfoList = scanResult.getClassesWithAnnotation(annotationRoot);
            for (ClassInfo routeClassInfo : routeClassInfoList) {
                AnnotationInfo annotationInfo = routeClassInfo.getAnnotationInfo(annotationRoot);
                AnnotationParameterValueList paramVals = annotationInfo.getParameterValues();
                scptcg.annotation.Card card = (scptcg.annotation.Card) annotationInfo.loadClassAndInstantiate();

                if (card.value().equals(name)) {
                    return (Card) routeClassInfo.loadClass().getDeclaredConstructor().newInstance();
                }
            }
        } catch (ClassGraphException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}