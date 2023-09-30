package com.azula.app.mapper;

import com.azula.app.persistence.entity.Contact;
import com.azula.app.persistence.entity.User;
import com.azula.app.service.DTO.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper <UserDTO, User>{
    @Override
    public User map(UserDTO in) {
        User user = new User();
        user.setNombre(in.getNombre());
        user.setEmail(in.getEmail());
        user.setPassword(in.getPassword());
        user.setEdad(in.getEdad());

        Contact contact = new Contact();
        contact.setTelefono(in.getTelefono());
        contact.setDireccion(in.getDireccion());

        contact.setUser(user);
        user.setContact(contact);
        return user;
    }
}
