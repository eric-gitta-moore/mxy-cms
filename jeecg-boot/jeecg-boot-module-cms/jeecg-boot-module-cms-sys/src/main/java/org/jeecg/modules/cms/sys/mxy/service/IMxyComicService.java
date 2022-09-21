package org.jeecg.modules.cms.sys.mxy.service;

import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComic;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 漫画列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
public interface IMxyComicService extends IService<MxyComic> {

	/**
	 * 添加一对多
	 *
	 * @param mxyComic
	 * @param mxyComicChapterList
	 */
	public void saveMain(MxyComic mxyComic,List<MxyComicChapter> mxyComicChapterList) ;
	
	/**
	 * 修改一对多
	 *
   * @param mxyComic
   * @param mxyComicChapterList
	 */
	public void updateMain(MxyComic mxyComic,List<MxyComicChapter> mxyComicChapterList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
