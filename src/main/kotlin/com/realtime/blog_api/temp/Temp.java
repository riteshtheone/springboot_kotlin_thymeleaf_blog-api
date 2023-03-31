//package com.realtime.blog_api.temp;
//
//import com.realtime.blog_api.bean.UserBean;
//import com.realtime.blog_api.dao.UserRepository;
//import com.realtime.blog_api.entity.User;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Temp {
//
//    private UserRepository userRepository;
//    public List<UserBean> getAllUsers(){
//        List<User> users = this.userRepository.findAll();
//        List<UserBean> userBeans = users.stream().map(user -> this.getUserBeanByUser(user)).collect(Collectors.toList());
//        return userBeans;
//    }
//
//    public UserBean getUserBeanByUser(User user){
//        UserBean userBean = new UserBean();
//        return userBean;
//    }
//}
