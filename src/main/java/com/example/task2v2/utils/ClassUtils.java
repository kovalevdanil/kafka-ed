package com.example.task2v2.utils;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

public class ClassUtils {

   private static final String BASE_PACKAGE = "com.example.task2v2";

   private ClassUtils() {}

   public static Set<Class<?>> findClassesAnnotatedWith(Class<? extends Annotation> annotationClass){
      Reflections reflections = new Reflections(BASE_PACKAGE);
      return reflections.getTypesAnnotatedWith(annotationClass);
   }

   public static <T> Set<Class<? extends T>> findClassesImplementingInterface(Class<T> interfaceClass){
      Reflections reflections = new Reflections(BASE_PACKAGE);
      return reflections.getSubTypesOf(interfaceClass);
   }
}
