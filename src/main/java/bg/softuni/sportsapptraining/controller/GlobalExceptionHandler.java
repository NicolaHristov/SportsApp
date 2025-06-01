package bg.softuni.sportsapptraining.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDenied(AccessDeniedException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/admin/manage-users";
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFound(EntityNotFoundException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/admin/manage-users";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleBadRequest(IllegalArgumentException ex, RedirectAttributes attrs) {
        attrs.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/admin/manage-users";
    }

}
