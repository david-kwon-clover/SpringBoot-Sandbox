package com.practice.Sandbox;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
}
