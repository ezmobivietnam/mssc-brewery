package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by ezmobivietnam on 2020-12-28.
 */
@Data
@NoArgsConstructor
public class CustomerDto extends BaseDto {
    private String name;

    @Builder
    public CustomerDto(UUID id, String name) {
        super(id);
        this.name = name;
    }
}
