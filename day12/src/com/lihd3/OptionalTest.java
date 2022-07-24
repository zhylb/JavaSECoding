package com.lihd3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 在使用 Optional 的时候需要考虑一些事情，以决定什么时候怎样使用它。
 *
 * 1 重要的一点是 Optional 不是 Serializable。因此，它不应该用作类的字段。
 *
 * 2 如果你需要序列化的对象包含 Optional 值，Jackson 库支持把 Optional 当作普通对象。也就是说，
 *      Jackson 会把空对象看作 null，而有值的对象则把其值看作对应域的值。这个功能在 jackson-modules-java8 项目中。
 *
 * 3 它在另一种情况下也并不怎么有用，就是在将其类型用作方法或构建方法的参数时。这样做会让代码变得复杂，完全没有必要.
 *      使用重载方法来处理非要的参数要容易得多。
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 21:50
 */
public class OptionalTest {
    //没有Optional之前 代码还没重构这么写 代码复杂且无聊
    public static String getIsoCode(User user){
//        if(user != null){
//            Address address = user.getAddress();
//            if(address!=null){
//                Country country = address.getCountry();
//                if (country != null) {
//                    String isocode = country.getIsocode();
//                    if (isocode != null) {
//                        return isocode.toUpperCase();
//                    }
//                }
//            }
//        }
        return "";
    }
    //有了Optional之后
    @Test
    public  void getIsoCodeOp(){
        // 几行代码就能搞定之前的工作，不过代价有点大，还得重构
        User u = new User();
        Optional<User> userOp = Optional.ofNullable(u);
        String result = userOp.flatMap(User::getAddress).flatMap(Address::getCountry).flatMap(Country::getIsocode).orElse("default");
        assertEquals(result, "default");
    }



    @Test
    public void whenGetStream_thenOk() {
        User user = new User( "john@gmail.com","1234");
        List<String> emails = Optional.ofNullable(user)
                .stream()
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"))
                .map( u -> u.getEmail())
                .collect(Collectors.toList());


        assertTrue(emails.size() == 1);
        assertEquals(emails.get(0), user.getEmail());
    }




}
