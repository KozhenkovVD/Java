package app.mapper;

import app.dto.CustomerDto;
import app.model.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

    Customer updateWithNull(CustomerDto customerDto, @MappingTarget Customer customer);
}