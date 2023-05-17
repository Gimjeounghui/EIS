package com.kun.eis.work.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkVO {

    private int w_no;
    private String m_email;
    private String w_title;
    private String w_contents;
    private LocalDateTime w_created_ate;
    private LocalDateTime w_updated_ate;
    private LocalDateTime w_deleted_ate;

}
