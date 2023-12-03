package kr.co.dbindexingtest.service;

import kr.co.dbindexingtest.domain.UserEntity;
import kr.co.dbindexingtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void registerManyUser() {
        List<UserEntity> names = new ArrayList<>();
        for(int i=0; i<1000000; i++) {
            String name = generateRandomString();

            names.add(UserEntity.builder()
                    .name(name)
                    .build());
        }

        names.add(UserEntity.builder()
                .name("LILJAY")
                .build());

        userRepository.saveAll(names);
    }

    public String findUserByName(String name) {
        UserEntity user = userRepository.findByName(name).orElseThrow(RuntimeException::new);
        return user.getName();
    }

    private String generateRandomString() {
        StringBuilder randomStringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            randomStringBuilder.append(randomChar);
        }

        return randomStringBuilder.toString();
    }
}