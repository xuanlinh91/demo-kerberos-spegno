package jp.co.ntt.common.dto.response.contact_box;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WkreqprgsResponse {
    private int error_count;
    private List<String> error;
    private WkreqprgsReturning returning;
}