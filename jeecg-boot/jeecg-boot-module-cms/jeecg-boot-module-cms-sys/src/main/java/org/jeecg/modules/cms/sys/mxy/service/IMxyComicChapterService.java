package org.jeecg.modules.cms.sys.mxy.service;

import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 漫画章节列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
public interface IMxyComicChapterService extends IService<MxyComicChapter> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<MxyComicChapter>
	 */
	public List<MxyComicChapter> selectByMainId(String mainId);
}
