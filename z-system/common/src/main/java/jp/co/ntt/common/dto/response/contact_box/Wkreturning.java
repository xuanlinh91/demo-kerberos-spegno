package jp.co.ntt.common.dto.response.contact_box;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wkreturning {
    private int id;
    private String wkreq_no;
    private int wkcategory_id;
    private String send_ymd;
    private String start_sch_ymd;
    private String fin_sch_ymd;
    private String alt_sch_ymd;
    private String start_ymd;
    private String fin_ymd;
    private int cur_stp;
    private int stp_cnt;
    private String req_user_id;
    private String dst_user_id;
    private String note;
    private String refer_url;
    private String boss_email;
    private String boss_com_nm;
    private String boss_org_nm;
    private String boss_zip;
    private String boss_adr1;
    private String boss_adr2;
    private String boss_adr3;
    private String boss_last_nm;
    private String boss_first_nm;
    private String boss_tel_no;
    private String crt_by;
    private String upd_by;
    private String crt_at;
    private String upd_at;
}
