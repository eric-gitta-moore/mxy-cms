package org.jeecg.modules.cms.sys.mxy.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 漫画章节列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
@ApiModel(value="mxy_comic_chapter对象", description="漫画章节列表")
@Data
@TableName("mxy_comic_chapter")
public class MxyComicChapter implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**漫画ID*/
    @ApiModelProperty(value = "漫画ID")
    private java.lang.String comicId;
	/**排序优先级*/
	@Excel(name = "排序优先级", width = 15)
    @ApiModelProperty(value = "排序优先级")
    private java.lang.Integer sort;
	/**标题*/
	@Excel(name = "标题", width = 15)
    @ApiModelProperty(value = "标题")
    private java.lang.String title;
	/**是否金币付费*/
	@Excel(name = "是否金币付费", width = 15)
    @ApiModelProperty(value = "是否金币付费")
    private java.lang.Integer isNeedCoin;
	/**审核状态*/
	@Excel(name = "审核状态", width = 15, dicCode = "mxy_examine_status")
    @ApiModelProperty(value = "审核状态")
    private java.lang.Integer examineStatus;
	/**审核原因*/
	@Excel(name = "审核原因", width = 15)
    @ApiModelProperty(value = "审核原因")
    private java.lang.String examineReason;
	/**是否VIP内容*/
	@Excel(name = "是否VIP内容", width = 15)
    @ApiModelProperty(value = "是否VIP内容")
    private java.lang.Integer isVip;
	/**采集来源唯一标识符*/
	@Excel(name = "采集来源唯一标识符", width = 15)
    @ApiModelProperty(value = "采集来源唯一标识符")
    private java.lang.String crawlOriginIdentity;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**删除日期*/
	@Excel(name = "删除日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "删除日期")
    private java.util.Date deleteTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
}
