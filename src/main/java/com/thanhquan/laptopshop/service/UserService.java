package com.thanhquan.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thanhquan.laptopshop.domain.User;
import com.thanhquan.laptopshop.repository.UserRepository;

@Service
public class UserService {
    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // lấy danh sách người dùng
    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

    // Lấy người dùng thông qua id
    public Optional<User> findUserById(Long id) {
        // lý do mà dùng Optional:
        // nếu không có id đó thì nó trả về nullpointerexcaption
        return this.userRepository.findById(id);
    }

    // Lấy người dùng theo email
    public List<User> findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    // lấy người dùng qua email và địa chỉ
    public List<User> findAllUserByEmailAndAddress(String email, String address) {
        return this.userRepository.findByEmailAndAddress(email, address);
    }

    // Lưu mới người dùng
    public User handleSaveUser(User newUser) {
        return this.userRepository.save(newUser);
    }

    // xóa người dùng
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }
}
