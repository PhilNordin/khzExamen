package com.philip.khzExamen.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String calendar(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        int daysInMonth = today.lengthOfMonth();
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 1 = Monday, 7 = Sunday

        List<List<Day>> weeks = new ArrayList<>();
        List<Day> week = new ArrayList<>();

        for (int i = 1 - startDayOfWeek; i <= daysInMonth; i++) {
            LocalDate date = firstDayOfMonth.plusDays(i - 1);
            week.add(new Day(date.getDayOfMonth(), date.isEqual(today)));
            if (date.getDayOfWeek().getValue() == 7 || date.getDayOfMonth() == daysInMonth) {
                weeks.add(new ArrayList<>(week));
                week.clear();
            }
        }

        model.addAttribute("weeks", weeks);
        return "calendar";
    }

    public record Day(int dayOfMonth, boolean today) {
    }
}