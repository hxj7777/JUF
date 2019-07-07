package com.atguigu.sh.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
class User {
    private Integer id;
    private String userName;
    private int age;
}

/**
 * @auther zzyy
 * @create 2019-02-26 22:24
 * <p>
 * 题目：请按照给出数据，找出同时满足以下条件的用户,也即以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 * 只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        System.out.println(list.stream().filter(user -> {
            return user.getId() % 2 == 0 && user.getAge() > 24;
        }).map(user -> {
            return user.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).collect(Collectors.toList()));
        System.out.println("hello hxj");
    }
}

