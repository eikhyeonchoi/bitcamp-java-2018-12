package ch28.d;

import java.lang.annotation.Repeatable;

//l 애노테이션 반복사용
public @interface MyAnnotation2s {
  MyAnnotation2[] value();

}
