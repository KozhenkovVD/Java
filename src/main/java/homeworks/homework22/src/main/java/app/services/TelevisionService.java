package app.services;

import app.dto.TelevisionDto;


import java.util.List;

public interface TelevisionService {
    List<TelevisionDto> getAll();
    void add(TelevisionDto television);
    void update(TelevisionDto television);
    void delete(TelevisionDto television);

}
