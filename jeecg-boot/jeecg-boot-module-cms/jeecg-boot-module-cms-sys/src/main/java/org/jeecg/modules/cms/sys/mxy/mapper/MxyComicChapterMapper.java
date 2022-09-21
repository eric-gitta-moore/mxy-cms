package org.jeecg.modules.cms.sys.mxy.mapper;

import java.util.List;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 漫画章节列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
public interface MxyComicChapterMapper extends BaseMapper<MxyComicChapter> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<MxyComicChapter>
   */
	public List<MxyComicChapter> selectByMainId(@Param("mainId") String mainId);
}
