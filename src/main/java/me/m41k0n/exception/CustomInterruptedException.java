package me.m41k0n.exception;

public class CustomInterruptedException extends Throwable {
    public CustomInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}