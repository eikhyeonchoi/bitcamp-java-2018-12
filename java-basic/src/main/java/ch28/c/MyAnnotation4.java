package ch28.c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//l 애노테이션 사용 범위
@Target(ElementType.LOCAL_VARIABLE) // 로컬 변수 선언에 붙일 수있음
public @interface MyAnnotation4 {

}
