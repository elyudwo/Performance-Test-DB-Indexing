package kr.co.dbindexingtest.controller;

import kr.co.dbindexingtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> registerManyUser() {
        userService.registerManyUser();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> findUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.findUserByName(name));
    }
}
