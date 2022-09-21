package org.jeecg.modules.cms.sys.mxy.service.impl;

import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import org.jeecg.modules.cms.sys.mxy.mapper.MxyComicChapterMapper;
import org.jeecg.modules.cms.sys.mxy.service.IMxyComicChapterService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 漫画章节列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
@Service
public class MxyComicChapterServiceImpl extends ServiceImpl<MxyComicChapterMapper, MxyComicChapter> implements IMxyComicChapterService {
	
	@Autowired
	private MxyComicChapterMapper mxyComicChapterMapper;
	
	@Override
	public List<MxyComicChapter> selectByMainId(String mainId) {
		return mxyComicChapterMapper.selectByMainId(mainId);
	}
}
