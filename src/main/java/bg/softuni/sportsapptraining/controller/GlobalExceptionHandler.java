package bg.softuni.sportsapptraining.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static bg.softuni.sportsapptraining.constant.ViewNames.REDIRECT_MANAGE_USERS;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDenied(AccessDeniedException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return REDIRECT_MANAGE_USERS;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFound(EntityNotFoundException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return REDIRECT_MANAGE_USERS;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleBadRequest(IllegalArgumentException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return REDIRECT_MANAGE_USERS;
    }

}
