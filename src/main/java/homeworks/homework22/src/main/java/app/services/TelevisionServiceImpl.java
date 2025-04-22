package app.services;

import app.dto.TelevisionDto;
import app.model.Television;
import lombok.RequiredArgsConstructor;
import app.repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import static app.dto.TelevisionDto.from;
import java.util.List;



@RequiredArgsConstructor
@Service
public class TelevisionServiceImpl implements TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Override
    public List<TelevisionDto> getAll() {
        return from(televisionRepository.findAll());
    }

    @Override
    public void add(TelevisionDto televisionDto) {
        Television television = Television.builder()
                .producer(televisionDto.getProducer())
                 .model(televisionDto.getModel())
                 .build();
        televisionRepository.save(television);
    }

    @Override
    public void update(TelevisionDto televisionDto) {
        Television television = Television.builder()
                .id(televisionDto.getId())
                .producer(televisionDto.getProducer())
                .model(televisionDto.getModel())
                .build();
        televisionRepository.save(television);

    }

    @Override
    public void delete(TelevisionDto televisionDto) {
        Television television = Television.builder()
                .id(televisionDto.getId())
                .producer(televisionDto.getProducer())
                .model(televisionDto.getModel())
                .build();
        televisionRepository.delete(television);
    }
}

