package com.Accolite.bookStore.Repository;

import com.Accolite.bookStore.Module.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface storeRepo extends JpaRepository<Users,Long> {
}
