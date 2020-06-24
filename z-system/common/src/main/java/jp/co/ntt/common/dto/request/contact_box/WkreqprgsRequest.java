package jp.co.ntt.common.dto.request.contact_box;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WkreqprgsRequest {
    private String wkreq_no;
    private String oper;
    private String fin_ymd;
    private String input_val;
}
