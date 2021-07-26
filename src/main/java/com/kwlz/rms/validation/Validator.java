package com.kwlz.rms.validation;

import com.kwlz.rms.dto.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
abstract public class Validator<T> {

    public abstract Set<ErrorMessage> validate(T searchDto);

}