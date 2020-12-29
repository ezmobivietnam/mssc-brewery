package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by ezmobivietnam on 2020-12-29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    private UUID id;
}
