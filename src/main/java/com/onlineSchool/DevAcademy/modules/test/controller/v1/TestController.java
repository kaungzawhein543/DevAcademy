package com.onlineSchool.DevAcademy.modules.test.controller.v1;

import com.onlineSchool.DevAcademy.common.constants.ConstantsVariables;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(ConstantsVariables.TEST_URl)
public class TestController {

    @GetMapping
    public ResponseEntity<String> testMapping(@RequestParam String name) {
        return ResponseEntity.ok("Hello " + name);
    }

    // 1. Functional Builder Style For ResponseEntity
    @GetMapping("/builder-style")
    public ResponseEntity<String> getBuilderStyle() {
        return ResponseEntity.ok()
                .header("Custom-header", "MyHeader")
                .body("Hello World From Builder Style");
    }

    // 2. Constructor Style For ResponseEntity
    @GetMapping("/constructor-style")
    public ResponseEntity<String> getConstructorStyle() {
        String body = "Hello World From Constructor Style";

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // 3. Custom Status For ResponseEntity
    @GetMapping("custom-status-style")
    public ResponseEntity<String> getCustomStatusStyle() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello World From Custom Status Style");
    }

    // 3. Wildcard Style For ResponseEntity
    @GetMapping("wildcard-style")
    public ResponseEntity<?> getWildCardStyle(@RequestParam boolean value) {

        Map<String, Object> objectMap = new HashMap<>();

        if (value) {
            objectMap.put("name", "Kaung Zaw Hein");
            objectMap.put("description", "Hello World from Wildcard Style");
            return ResponseEntity.ok(objectMap);
        } else {
            objectMap.put("error", "User not found!");
            objectMap.put("description", "Hello World from Wildcard Style");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectMap);
        }
    }
}
