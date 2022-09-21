package org.jeecg.modules.cms.sys.mxy.vo;

import java.util.List;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComic;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 漫画列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
@Data
@ApiModel(value="mxy_comicPage对象", description="漫画列表")
public class MxyComicPage {

	/**主键*/
	@ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**漫画名*/
	@Excel(name = "漫画名", width = 15)
	@ApiModelProperty(value = "漫画名")
    private java.lang.String name;
	/**英文名*/
	@Excel(name = "英文名", width = 15)
	@ApiModelProperty(value = "英文名")
    private java.lang.String nameEng;
	/**所属分类*/
	@Excel(name = "所属分类", width = 15)
	@ApiModelProperty(value = "所属分类")
    private java.lang.String categoryId;
	/**是否推荐*/
	@Excel(name = "是否推荐", width = 15)
	@ApiModelProperty(value = "是否推荐")
    private java.lang.Integer isRecommend;
	/**竖封面*/
	@Excel(name = "竖封面", width = 15)
	@ApiModelProperty(value = "竖封面")
    private java.lang.String coverVertical;
	/**横封面*/
	@Excel(name = "横封面", width = 15)
	@ApiModelProperty(value = "横封面")
    private java.lang.String coverHorizontal;
	/**更新状态*/
	@Excel(name = "更新状态", width = 15, dicCode = "mxy_update_status")
    @Dict(dicCode = "mxy_update_status")
	@ApiModelProperty(value = "更新状态")
    private java.lang.Integer updateStatus;
	/**作者账号*/
	@Excel(name = "作者账号", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@ApiModelProperty(value = "作者账号")
    private java.lang.String authorId;
	/**作者名称*/
	@Excel(name = "作者名称", width = 15)
	@ApiModelProperty(value = "作者名称")
    private java.lang.String authorName;
	/**公告*/
	@Excel(name = "公告", width = 15)
	@ApiModelProperty(value = "公告")
    private java.lang.String notice;
	/**文作者*/
	@Excel(name = "文作者", width = 15)
	@ApiModelProperty(value = "文作者")
    private java.lang.String characterAuthor;
	/**图作者*/
	@Excel(name = "图作者", width = 15)
	@ApiModelProperty(value = "图作者")
    private java.lang.String picAuthor;
	/**短介绍*/
	@Excel(name = "短介绍", width = 15)
	@ApiModelProperty(value = "短介绍")
    private java.lang.String intro;
	/**长介绍*/
	@Excel(name = "长介绍", width = 15)
	@ApiModelProperty(value = "长介绍")
    private java.lang.String summary;
	/**总点击量*/
	@Excel(name = "总点击量", width = 15)
	@ApiModelProperty(value = "总点击量")
    private java.lang.Integer totallyClickAmmount;
	/**月点击量*/
	@Excel(name = "月点击量", width = 15)
	@ApiModelProperty(value = "月点击量")
    private java.lang.Integer monthlyClickAmmount;
	/**周点击量*/
	@Excel(name = "周点击量", width = 15)
	@ApiModelProperty(value = "周点击量")
    private java.lang.Integer weeklyClickAmmount;
	/**日点击量*/
	@Excel(name = "日点击量", width = 15)
	@ApiModelProperty(value = "日点击量")
    private java.lang.Integer dailyClickAmmount;
	/**收藏量*/
	@Excel(name = "收藏量", width = 15)
	@ApiModelProperty(value = "收藏量")
    private java.lang.Integer collectionAmmount;
	/**是否付费*/
	@Excel(name = "是否付费", width = 15)
	@ApiModelProperty(value = "是否付费")
    private java.lang.Integer isNeedPay;
	/**打赏金额*/
	@Excel(name = "打赏金额", width = 15)
	@ApiModelProperty(value = "打赏金额")
    private java.math.BigDecimal rewardAmmount;
	/**是否被锁定*/
	@Excel(name = "是否被锁定", width = 15)
	@ApiModelProperty(value = "是否被锁定")
    private java.lang.Integer isLocked;
	/**采集来源标识符*/
	@Excel(name = "采集来源标识符", width = 15)
	@ApiModelProperty(value = "采集来源标识符")
    private java.lang.String crawlOriginIdentity;
	/**审核时间*/
	@Excel(name = "审核时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "审核时间")
    private java.util.Date examineTime;
	/**审核原因*/
	@Excel(name = "审核原因", width = 15)
	@ApiModelProperty(value = "审核原因")
    private java.lang.String examineReason;
	/**审核状态*/
	@Excel(name = "审核状态", width = 15, dicCode = "mxy_examine_status")
    @Dict(dicCode = "mxy_examine_status")
	@ApiModelProperty(value = "审核状态")
    private java.lang.Integer examineStatus;
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
	/**创建人*/
	@ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**更新人*/
	@ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**所属部门*/
	@ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;

	@ExcelCollection(name="漫画章节列表")
	@ApiModelProperty(value = "漫画章节列表")
	private List<MxyComicChapter> mxyComicChapterList;

}
