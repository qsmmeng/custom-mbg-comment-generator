package com.qs.mmeng.entity;

import java.time.LocalDateTime;

/**
 * mbg-custom-comment-generator
 * 
 * @author qsmmeng
 * @date 2019-01-23 16:36:18
 */
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

    /**
     * @return 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 歌手名字
     */
    public String getSingerName() {
        return singerName;
    }

    /**
     * @param singerName 歌手名字
     */
    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    /**
     * @return 歌曲名称
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName 歌曲名称
     */
    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    /**
     * @return 歌曲类型:：-1：其他；0：网络歌曲；1：流行歌曲；2：怀旧经典；3：纯音乐；4：儿歌；
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type 歌曲类型:：-1：其他；0：网络歌曲；1：流行歌曲；2：怀旧经典；3：纯音乐；4：儿歌；
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 时长(interval是关键字)
     */
    public Integer getIntervals() {
        return intervals;
    }

    /**
     * @param intervals 时长(interval是关键字)
     */
    public void setIntervals(Integer intervals) {
        this.intervals = intervals;
    }

    /**
     * @return 状态 -1：删除 0：正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态 -1：删除 0：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 创建者id
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy 创建者id
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return 创建者名字
     */
    public String getCreateByName() {
        return createByName;
    }

    /**
     * @param createByName 创建者名字
     */
    public void setCreateByName(String createByName) {
        this.createByName = createByName == null ? null : createByName.trim();
    }

    /**
     * @return 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 更新者id
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy 更新者id
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return 更新者名字
     */
    public String getUpdateByName() {
        return updateByName;
    }

    /**
     * @param updateByName 更新者名字
     */
    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName == null ? null : updateByName.trim();
    }

    /**
     * @return 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 音频外链
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url 音频外链
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
