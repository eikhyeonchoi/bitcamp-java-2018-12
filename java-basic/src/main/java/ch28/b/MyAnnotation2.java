package ch28.b;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//l 애노테이션 유지 범위 지정
//l ==> 아무것도 지정하지 않으면 기본이 Class
//l ==> 또는 다음과 같이 명시적으로 지정할 수 있음
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation2 {

}
