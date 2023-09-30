package com.azula.app.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
