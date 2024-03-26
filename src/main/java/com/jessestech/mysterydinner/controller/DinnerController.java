package com.jessestech.mysterydinner.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class DinnerController {

    private final Random random = new Random();

    @GetMapping("/mysterydinner")
    public DinnerOptions randomizeDinner() throws IOException {
        String protein = getRandomLine("protein.txt");
        String addOn1 = getRandomLine("add_ons.txt");
        String addOn2;
        do {
            addOn2 = getRandomLine("add_ons.txt");
        } while (addOn1.equals(addOn2));
        return new DinnerOptions(protein, List.of(addOn1, addOn2));
    }

    private String getRandomLine(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(new ClassPathResource(fileName).getURI()));
        Collections.shuffle(lines);
        return lines.get(random.nextInt(lines.size()));
    }

    static class DinnerOptions {
        private String protein;
        private List<String> addOns;

        public DinnerOptions(String protein, List<String> addOns) {
            this.protein = protein;
            this.addOns = addOns;
        }

        // Getters (required for JSON serialization)
        public String getProtein() {
            return protein;
        }

        public List<String> getAddOns() {
            return addOns;
        }
    }
}
