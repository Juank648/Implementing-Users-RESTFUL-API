package com.restfulapi.springboot.service.impl;

import com.restfulapi.springboot.data.User;
import com.restfulapi.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceHashMap implements UserService {

    public HashMap <String, User> UserMap = new HashMap <String, User>();

    public HashMap<String, User> getUserMap() {
        return UserMap;
    }

    public void setUserMap(HashMap<String, User> userMap) {
        UserMap = userMap;
    }

    @Override
    public User create(User user) {
        UserMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return UserMap.getOrDefault(id, null);
    }

    @Override
    public List<User> getAll() {
        List<User> list = UserMap.values()
                .stream()
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void deleteById(String id) {
        UserMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        UserMap.remove(userId);
        UserMap.put(userId, user);
        return user;
    }
}
