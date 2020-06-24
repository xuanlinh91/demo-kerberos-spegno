package jp.co.ntt.common.dto.response.contact_box;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReminderEmail {
    private String id;
    private String wkreq_no;
    private int wkcategory_id;
    private String wkcategory_nm;
    private String send_ymd;
    private String start_sch_ymd;
    private String fin_sch_ymd;
    private String alt_sch_ymd;
    private String start_ymd;
    private String fin_ymd;
    private int cur_stp;
    private int stp_cnt;
    private String task_nm;
    private int due_soon;
    private String req_user_id;
    private String req_com_nm;
    private String req_org_nm;
    private String req_zip;
    private String req_adr1;
    private String req_adr2;
    private String req_adr3;
    private String req_last_nm;
    private String req_first_nm;
    private String req_last_nm_k;
    private String req_first_nm_k;
    private String req_email;
    private String req_tel_no;
    private String dst_user_id;
    private String dst_com_nm;
    private String dst_org_nm;
    private String dst_zip;
    private String dst_adr1;
    private String dst_adr2;
    private String dst_adr3;
    private String dst_last_nm;
    private String dst_first_nm;
    private String dst_last_nm_k;
    private String dst_first_nm_k;
    private String dst_email;
    private String dst_tel_no;
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
}
