package com.thanhquan.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanhquan.laptopshop.domain.User;

import java.util.List;

// kế thừa từ generic 
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository đã có sẵn hàm save(entity), không cần định nghĩa lại
    
    // Spring Data JPA sẽ tự động tạo query từ tên phương thức
    List<User> findByEmail(String email);

    // Tương tự, Spring sẽ tạo query: "find users by email and address"
    List<User> findByEmailAndAddress(String email, String address);
}
