package com.bookshop.HacmeBooks2.users.model.validators;

import org.springframework.beans.DirectFieldAccessor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author https://memorynotfound.com/field-matching-bean-validation-annotation-example/
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object sourceObject, final ConstraintValidatorContext context) {
        DirectFieldAccessor wrapper = new DirectFieldAccessor(sourceObject);
        final Object firstObj = wrapper.getPropertyValue(firstFieldName);
        final Object secondObj = wrapper.getPropertyValue(secondFieldName);
        boolean valid = Objects.equals(firstObj, secondObj);
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
