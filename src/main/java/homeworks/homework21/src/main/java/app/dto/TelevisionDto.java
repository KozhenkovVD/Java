package app.dto;

import app.model.Television;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelevisionDto {
        private Long id;
        private String producer;
        private String model;

        public static TelevisionDto from(Television television) {
            return TelevisionDto.builder()
                    .id(television.getId())
                    .producer(television.getProducer())
                    .model(television.getModel())
                    .build();
        }
        public static List<TelevisionDto> from(List<Television> television) {
                return television.stream().map(TelevisionDto::from).collect(Collectors.toList());
        }
}
