package com.kun.eis.work.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkFileVO {

    private int w_file_no;
    private int w_no;
    private String w_file;
    private String w_file_path;
    private LocalDateTime w_file_created_ate;
    private LocalDateTime w_file_updated_ate;
    private LocalDateTime w_file_deleted_ate;
}
