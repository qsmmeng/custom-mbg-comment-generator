package com.qs.mmeng.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * mbg-custom-comment-generator
 * 
 * @author qsmmeng
 * @date 2019-01-24 11:28:43
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    /**
     * 主键
     */
    private Long id;

    /**
     * 歌手名字
     */
    private String singerName;

    /**
     * 歌曲名称
     */
    private String songName;

    /**
     * 歌曲类型:：-1：其他；0：网络歌曲；1：流行歌曲；2：怀旧经典；3：纯音乐；4：儿歌；
     */
    private Integer type;

    /**
     * 时长(interval是关键字)
     */
    private Integer intervals;

    /**
     * 状态 -1：删除 0：正常
     */
    private Integer status;

    /**
     * 创建者id
     */
    private Long createBy;

    /**
     * 创建者名字
     */
    private String createByName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者id
     */
    private Long updateBy;

    /**
     * 更新者名字
     */
    private String updateByName;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 音频外链
     */
    private String url;
}