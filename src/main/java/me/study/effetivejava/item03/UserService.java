package me.study.effetivejava.item03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;  // Bean으로 등록된 클래스를 autowired 해서 쓰는 것도 싱글톤의 한 예 (다만, applicationContext에서 꺼내쓰는 것에 한해서..)

}
