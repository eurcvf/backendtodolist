package br.com.eurcvf.backendtodolist.user.repositories;

import br.com.eurcvf.backendtodolist.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByUsername(String username);

}
