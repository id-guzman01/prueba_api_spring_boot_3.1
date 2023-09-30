package com.azula.app.mapper;

import com.azula.app.persistence.entity.Contact;
import com.azula.app.service.DTO.ContactDTO;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements IMapper<ContactDTO, Contact>{
    @Override
    public Contact map(ContactDTO in) {
        Contact contact = new Contact();
        contact.setTelefono(in.getTelefono());
        contact.setDireccion(in.getDireccion());
        return  contact;
    }
}
