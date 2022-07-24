package com.lihd3;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 22:54
 */
public class OptionalMethodTest {
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = new User("anna@gmail.com", "1234");
        
        Optional<User> opt = Optional.of(user);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        assertEquals("John", opt.get());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        assertTrue(opt.isPresent());

        assertEquals(user.getEmail(), opt.get().getEmail());
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals(user2.getEmail(), result.getEmail());
    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        User user = new User("john@gmail.com","1234");
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals("john@gmail.com", result.getEmail());
    }

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = null;
        System.out.println(("Using orElse"));
        User result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println(("Using orElseGet"));
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        System.out.println(("Creating New User"));
        return new User("extra@gmail.com", "1234");
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {
        User user = new User("john@gmail.com", "1234");
        System.out.println(("Using orElse"));
        User result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println(("Using orElseGet"));
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThrowException_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user).orElseThrow( () -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");

        assertEquals(email, user.getEmail());
    }


    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        assertTrue(result.isPresent());
    }
}
