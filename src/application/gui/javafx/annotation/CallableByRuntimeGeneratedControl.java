package application.gui.javafx.annotation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CallableByRuntimeGeneratedControl {

    String controlType() default "";

    String promptText() default "";

    String description() default "";
}


